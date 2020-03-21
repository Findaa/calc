package com.upcprovision.calc.dto;

import com.upcprovision.calc.validation.PasswordMatches;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@PasswordMatches
public class UserDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String password2;

    @NotNull
    @NotEmpty
    private String mail;

    @NotNull
    @NotEmpty
    private String leader;

    public UserDTO(@NotNull @NotEmpty String username, @NotNull @NotEmpty String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO() {
    }

    public UserDTO(@NotNull @NotEmpty String username, @NotNull @NotEmpty String password, @NotNull @NotEmpty String password2, @NotNull @NotEmpty String mail, @NotNull @NotEmpty String leader) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.mail = mail;
        this.leader = leader;
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

}
