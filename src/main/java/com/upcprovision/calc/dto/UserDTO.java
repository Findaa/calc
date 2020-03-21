package com.upcprovision.calc.dto;

import com.upcprovision.calc.validation.PasswordMatches;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@PasswordMatches
public class UserDTO implements Serializable {
    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String username;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String password;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String password2;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String mail;

    @NotNull
    @NotEmpty
    @Getter
    @Setter
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
}
