package com.upcprovision.calc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServicesImpl implements UserService {

    UserRepo userRepo;

    @Autowired
    public UserServicesImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void add(String username, String password, String mail, Set<Role> roles, int leaderid) {
        User user = new User(username, password, mail, 1, roles, 1);
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
        if (user.isPresent()) {
            return user.get();
        } else return null;
    }

    @Override
    public User getByMail(String mail) {
        Optional<User> user = userRepo.findUserByMail(mail);
        if (user.isPresent()) {
            return user.get();
        } else return null;
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

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLeaderid() == id) {
                tempUsers.add(users.get(i));
            }
        }
        return tempUsers;
    }
}

