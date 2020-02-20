//package com.upcprovision.calc.controller;
//
//import com.auth0.jwt.interfaces.Header;
//import com.upcprovision.calc.controller.provision.ControllerServices;
//import com.upcprovision.calc.dto.UserDTO;
//import com.upcprovision.calc.model.User;
//import com.upcprovision.calc.repos.UserRepo;
//
//import com.upcprovision.calc.repos.provision.LeaderService;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class JWTUserController {
//    private UserRepo applicationUserRepository;
//    private ControllerServices controllerServices;
//    private LeaderService leaderService;
//
//    public JWTUserController(UserRepo applicationUserRepository, ControllerServices controllerServices, LeaderService leaderService) {
//        this.applicationUserRepository = applicationUserRepository;
//        this.controllerServices = controllerServices;
//        this.leaderService = leaderService;
//    }
//
//    @PostMapping("/sign-up")
//    public void signUp(@RequestBody UserDTO userDTO) { ;
//        User user =
//                new User(userDTO.getUsername(), BCrypt.hashpw(userDTO.getPassword(),
//                        BCrypt.gensalt(11)), userDTO.getMail(), false,
//                        controllerServices.getUserAuth(), leaderService.getLeader(userDTO.getLeader()));
//        applicationUserRepository.save(user);
//    }
//
//    @RequestMapping("/test")
//    public void test(@RequestBody Header header){
//
//        System.out.println(header.toString());
//    }
//}