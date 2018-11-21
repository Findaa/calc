package com.upcprovision.calc.security;

import java.util.List;
import java.util.Set;

public interface UserService  {
    List<User> listAll();
    User getByUsername(String username);
    User getById(Long id);
    User getByMail(String mail);
    void delete(Long id);
    void deleteUser(User users);
    Long getIdFromUsername(String username);
    void add(String username, String password, String mail, Set<Role> roles, int leaderid);
    void add(User user);
    List<User> findAllByLeaderid(int id);
}