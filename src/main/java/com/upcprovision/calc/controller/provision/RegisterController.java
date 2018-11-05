package com.upcprovision.calc.controller.provision;

import com.upcprovision.calc.dto.UserDTO;
import com.upcprovision.calc.model.Role;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.provision.LeaderInterface;
import com.upcprovision.calc.repos.UserRepo;

import com.upcprovision.calc.services.MailService;
import com.upcprovision.calc.services.RegisterServices;
import com.upcprovision.calc.services.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegisterController {


    private RegisterServices registerServices;
    private UserRepo userRepo;
    private LeaderInterface leaderService;
    private VerificationTokenService tokenService;
    private MailService mailService;

    @Autowired
    public RegisterController(RegisterServices registerServices, UserRepo userRepo, LeaderInterface leaderService, VerificationTokenService tokenService, MailService mailService) {
        this.registerServices = registerServices;
        this.userRepo = userRepo;
        this.leaderService = leaderService;
        this.tokenService = tokenService;
        this.mailService = mailService;
    }

    public Set<Role> getUserAuth() {
        Set<Role> auth = new HashSet<>();
        auth.add(new Role("USER"));
        return auth;
    }

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @GetMapping("/active")
    public String viewActivated(@ModelAttribute("id") String token, Model model) {
        model.addAttribute("user", new UserDTO());
        System.out.println("***acctivate***");
        System.out.println(token + " id");
        registerServices.activate(token);
        model.addAttribute("x", "registered");
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserDTO userDTO, Model model) {
        System.out.println("Register controller");
        System.out.println(userDTO.getMail() + " mail");
        System.out.println(getUserAuth() + " ROLE");
        System.out.println(userDTO.getLeader() + " leader");

        User user = new User(userDTO.getUsername(), BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(11)), userDTO.getMail(), 0, getUserAuth(), leaderService.getLeader(userDTO.getLeader()));
        System.out.println(user.toString() + ": ****registerusertest");
        if (registerServices.passCompare(userDTO) && registerServices.validate(userDTO.getUsername(), userDTO.getMail())) {
            userRepo.save(user);
            String token = tokenService.generateToken(user).getToken();
            System.out.println(token + ": Token test");
            mailService.sendSimpleMessage(userDTO.getMail(), "ACTIVATE ACCOUNT", registerServices.mail(token));
            model.addAttribute("user", userDTO);
            model.addAttribute("x", "udane");
        } else {
            model.addAttribute("x", "nieudane");
        }
        return "register";
    }

    @GetMapping("/registered")
    public String viewRegistered(Model model) {
        return "registered";
    }
}



