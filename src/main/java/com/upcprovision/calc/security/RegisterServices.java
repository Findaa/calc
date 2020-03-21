package com.upcprovision.calc.security;

import com.upcprovision.calc.dto.UserDTO;
import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.TokenRepo;
import com.upcprovision.calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServices {
    @Autowired
    public RegisterServices(UserService userService, TokenRepo tokenRepo) {
        this.userService = userService;
        this.tokenRepo = tokenRepo;
    }

    private UserService userService;
    private TokenRepo tokenRepo;

    public boolean passCompare(UserDTO userDTO) {
        return userDTO.getPassword().equals(userDTO.getPassword2());
    }

    public boolean validate(String username, String mail) {
        return (userService.getByUsername(username) == null && userService.getByMail(mail) == null);
    }

    public String mail(String token) {
        return "Dziekuje za rejestracje. Kliknij link aby potwierdzyc. " + System.lineSeparator() + "http://localhost:8080/active?id=" + token;
    }

    public void activate(String token) throws NullPointerException {
        RegisterVerificationToken entityToken = tokenRepo.getByToken(token);
        User user = new User();
        if (entityToken != null) {
            user = entityToken.getUser();
        }
        if (user != null) {
            user = userService.getById(user.getId());
            try {
                if (entityToken.getExpiryDate().before(new Date())) {
                    user.setActive(true);
                    userService.add(user);
                }
            } catch (NullPointerException e) {
                System.out.println("NPE on activation: " + user.getUsername() + " " +
                        "\n Current status: " + user.isActive() + "" +
                        "\n Expiry Date: " + entityToken.getExpiryDate() + "" +
                        "\n Current Date: " + new Date());
            }
        }
    }
}