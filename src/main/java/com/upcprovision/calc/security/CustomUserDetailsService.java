package com.upcprovision.calc.security;

import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optional = userRepo.findUserByUsername(s);
        optional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optional.map(CustomUserDetails::new).get();

    }
}
