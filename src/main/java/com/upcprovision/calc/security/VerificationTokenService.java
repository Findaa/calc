package com.upcprovision.calc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class VerificationTokenService {
    private static final int EXPIRATION = 60*24;

    @Autowired
    TokenRepo tokenRepo;

    private String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] symbols = CHARACTERS.toCharArray();

    public VerificationToken generateToken(User user) {
        char[] tokeno = new char[10];
        for(int i=0; i<tokeno.length; i++){
            int idx = new Random().nextInt(symbols.length);
            char random = symbols[idx];
           tokeno[i]=random;
        }
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setExpiryDate(calculateExpiryDate(EXPIRATION));
        token.setToken(String.valueOf(tokeno));
        tokenRepo.save(token);
        return token;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

}