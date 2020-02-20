package com.upcprovision.calc.security.testToken;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

public class HeaderUsernameAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public HeaderUsernameAuthenticationFilter() {
        super();
        this.setFilterProcessesUrl("/**");
        this.setPostOnly(false);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        System.out.println(request.getHeader(this.getPasswordParameter().toString() + " pass"));
        return request.getHeader(this.getPasswordParameter());
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getHeader(this.getPasswordParameter());
    }

}