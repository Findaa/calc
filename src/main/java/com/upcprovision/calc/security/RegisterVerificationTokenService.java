package com.upcprovision.calc.security;

import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class RegisterVerificationTokenService {
    @Autowired
    public RegisterVerificationTokenService(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    private static final int EXPIRATION = 60 * 24;
    private char[] symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private TokenRepo tokenRepo;

    public RegisterVerificationToken generateToken(User user) {
        char[] tokeno = new char[10];

        for (int i = 0; i < tokeno.length; i++) {
            int idx = new Random().nextInt(symbols.length);
            char random = symbols[idx];
            tokeno[i] = random;
        }

        RegisterVerificationToken token = new RegisterVerificationToken();
        token.setUser(user);
        token.setExpiryDate(calculateExpiryDate(EXPIRATION));
        token.setToken(String.valueOf(tokeno));
        tokenRepo.save(token);
        return token;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new Timestamp(cal.getTime().getTime()));
            cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        } catch (NullPointerException npe) {
            cal.add(Calendar.MINUTE, 1);
            System.out.println("NPE on calculateExpiryDate, set on 1 minute");
        }
        return new Date(cal.getTime().getTime());
    }
}