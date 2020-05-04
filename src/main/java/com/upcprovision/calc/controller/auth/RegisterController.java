package com.upcprovision.calc.controller.auth;

import com.upcprovision.calc.controller.ControllerServices;
import com.upcprovision.calc.dto.UserDTO;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.services.provision.LeaderService;
import com.upcprovision.calc.repos.UserRepo;

import com.upcprovision.calc.services.MailService;
import com.upcprovision.calc.security.RegisterServices;
import com.upcprovision.calc.security.RegisterVerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    public RegisterController(RegisterServices registerServices, UserRepo userRepo,
                              LeaderService leaderService, RegisterVerificationTokenService tokenService,
                              MailService mailService, ControllerServices controllerServices) {
        this.registerServices = registerServices;
        this.userRepo = userRepo;
        this.leaderService = leaderService;
        this.tokenService = tokenService;
        this.mailService = mailService;
        this.controllerServices = controllerServices;
    }

    private RegisterServices registerServices;
    private UserRepo userRepo;
    private LeaderService leaderService;
    private RegisterVerificationTokenService tokenService;
    private MailService mailService;
    private ControllerServices controllerServices;

    @GetMapping("/register")
    public String viewRegister(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/register";
    }

    @GetMapping("/active")
    public String viewActivated(@ModelAttribute("id") String token, Model model) {
        model.addAttribute("user", new UserDTO());
        registerServices.activate(token);
        model.addAttribute("x", "registered");
        return "/register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserDTO userDTO, Model model) throws InterruptedException {
        System.out.println("test: " + userDTO.getUsername());
        if(userDTO.getLeader() == null){
            userDTO.setLeader("leader1");
        }
        System.out.println(userDTO.getLeader() + ": Leader from Registration");
        User user =
                new User(userDTO.getUsername(), BCrypt.hashpw(userDTO.getPassword(),
                        BCrypt.gensalt(11)), userDTO.getMail(), false,
                        controllerServices.getUserAuth(), leaderService.getLeader(userDTO.getLeader()));

        if (registerServices.passCompare(userDTO) && registerServices.validate(userDTO.getUsername(), userDTO.getMail())) {
            userRepo.save(user);
            String token = tokenService.generateToken(user).getToken();
            mailService.sendSimpleMessage(userDTO.getMail(), "ACTIVATE ACCOUNT", registerServices.mail(token));
            model.addAttribute("user", userDTO);
            model.addAttribute("x", "udane");
        } else {
            model.addAttribute("x", "nieudane");
        }

        System.out.println(" test role w/o ");
        return "/register";
    }

    @GetMapping("/registered")
    public String viewRegistered() {
        return "/registered";
    }
}



