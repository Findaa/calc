package com.upcprovision.calc.model;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private int active;
    @Column(name= "leader")
    private int leaderid;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns =
            @JoinColumn(name = "user_id"),
            inverseJoinColumns =
            @JoinColumn(name = "role_id"))
    private Set<Role> roles;






    public User(String username, String password, String mail, int active, Set<Role> roles, int leaderid) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.active = active;
        this.roles = roles;
        this.leaderid = leaderid;
    }

    public User() {
    }

    public User(User user) {
        this.active = user.getActive();
        this.mail = user.getMail();
        this.roles = user.getRoles();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
        this.leaderid = user.getLeaderid();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(int leaderid) {
        this.leaderid = leaderid;
    }

}
