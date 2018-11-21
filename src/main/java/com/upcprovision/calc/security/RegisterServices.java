package com.upcprovision.calc.security;

import com.upcprovision.calc.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    private UserService userService;
    private TokenRepo tokenRepo;

    @Autowired
    public RegisterServices(UserService userService, TokenRepo tokenRepo) {
        this.userService = userService;
        this.tokenRepo = tokenRepo;
    }

    public boolean passCompare(UserDTO userDTO) {
        return userDTO.getPassword().equals(userDTO.getPassword2());
    }

    public boolean validate(String username, String mail) {
        return (userService.getByUsername(username) == null && userService.getByMail(mail) == null);
    }

    public String mail(String token) {
        return "Dziekuje za rejestracje. Kliknij link aby potwierdzyc. " + System.lineSeparator() + "http://localhost:8080/active?id=" + token;
    }

    public void activate(String token) {
        VerificationToken entitytoken = tokenRepo.getByToken(token);
        User user = new User();
        if (entitytoken != null) {
            user = entitytoken.getUser();
        }
        if (user != null) {
            user = userService.getById(user.getId());
            user.setActive(1);
            userService.add(user);
        }
    }
}