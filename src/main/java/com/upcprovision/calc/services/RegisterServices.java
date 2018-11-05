package com.upcprovision.calc.services;

import com.upcprovision.calc.dto.UserDTO;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.model.VerificationToken;
import com.upcprovision.calc.repos.TokenRepo;
import com.upcprovision.calc.repos.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    @Autowired
    UserService userService;
    @Autowired
    TokenRepo tokenRepo;

    public boolean passCompare(UserDTO userDTO) {
        return userDTO.getPassword().equals(userDTO.getPassword2());
    }

    public boolean validate(String username, String mail) {
        if (userService.getByUsername(username) == null && userService.getByMail(mail) == null) {
            return true;
        }
        return false;
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