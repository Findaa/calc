package com.upcprovision.calc.security.user;

import com.upcprovision.calc.model.User;
import com.upcprovision.calc.repos.UserRepo;
import com.upcprovision.calc.security.user.Role;
import com.upcprovision.calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServicesImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServicesImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void add(String username, String password, String mail, Set<Role> roles, int leaderid) {
        User user = new User(username, password, mail, true, roles, 1);
        userRepo.save(user);
    }

    @Override
    public void add(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> listAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public void delete(Long id) {
        userRepo.delete(userRepo.findUserById(id));
    }

    @Override
    public void deleteUser(User users) {
        userRepo.delete(users);
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> user = userRepo.findUserByUsername(username);
        return user.orElse(null);
    }

    @Override
    public User getByMail(String mail) {
        Optional<User> user = userRepo.findUserByMail(mail);
        return user.orElse(null);
    }

    @Override
    public Long getIdFromUsername(String username) {
        Long i = userRepo.findUserByUsername(username).get().getId();
        if (userRepo.findUserByUsername(username).isPresent()) {
            return i;
        } else return null;
    }

    @Override
    public List<User> findAllByLeaderid(int id) {
        List<User> users = userRepo.findAll();
        List<User> tempUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getLeaderid() == id) {
                tempUsers.add(user);
            }
        }
        return tempUsers;
    }

    @Override
    public String generateAuthToken(String username, String password)
    {
        String credentials = username.concat(password);
        return BCrypt.hashpw(credentials, "11");
    }
}

