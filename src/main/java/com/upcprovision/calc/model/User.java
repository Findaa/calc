package com.upcprovision.calc.model;

import com.upcprovision.calc.security.user.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "mail")
    private String mail;
    @Column(name = "active")
    private boolean active;
    @Column(name= "leader")
    private int leaderid;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns =
            @JoinColumn(name = "user_id"),
            inverseJoinColumns =
            @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, String password, String mail, boolean active, Set<Role> roles, int leaderid) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.active = active;
        this.roles = roles;
        this.leaderid = leaderid;
    }

    public User() { }

    public User(User user) {
        this.active = user.isActive();
        this.mail = user.getMail();
        this.roles = user.getRoles();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
        this.leaderid = user.getLeaderid();
    }

}
