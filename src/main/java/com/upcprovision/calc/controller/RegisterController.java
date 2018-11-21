package com.upcprovision.calc.controller;

import com.upcprovision.calc.dto.UserDTO;
import com.upcprovision.calc.security.Role;
import com.upcprovision.calc.security.User;
import com.upcprovision.calc.repos.provision.LeaderService;
import com.upcprovision.calc.security.UserRepo;

import com.upcprovision.calc.repos.MailService;
import com.upcprovision.calc.security.RegisterServices;
import com.upcprovision.calc.security.VerificationTokenService;
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
    private LeaderService leaderService;
    private VerificationTokenService tokenService;
    private MailService mailService;


    @Autowired
    public RegisterController(RegisterServices registerServices, UserRepo userRepo, LeaderService leaderService, VerificationTokenService tokenService, MailService mailService) {
        this.registerServices = registerServices;
        this.userRepo = userRepo;
        this.leaderService = leaderService;
        this.tokenService = tokenService;
        this.mailService = mailService;
    }

    private Set<Role> getUserAuth() {
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
    public String postRegister(@ModelAttribute("user") UserDTO userDTO, Model model) throws InterruptedException {
        User user = new User(userDTO.getUsername(), BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(11)), userDTO.getMail(), 0, getUserAuth(), leaderService.getLeader(userDTO.getLeader()));
        if (registerServices.passCompare(userDTO) && registerServices.validate(userDTO.getUsername(), userDTO.getMail())) {
            userRepo.save(user);
            String token = tokenService.generateToken(user).getToken();
            System.out.println(userDTO.getMail()+" mail");
            System.out.println(token+" token");
            System.out.println(registerServices.mail(token)+" mailTxt");
            System.out.println(userDTO.getMail()+ " ACTIVATE ACCOUNT "+ registerServices.mail(token));
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



