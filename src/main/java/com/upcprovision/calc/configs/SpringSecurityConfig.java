package com.upcprovision.calc.configs;

import com.upcprovision.calc.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Order(1)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SpringSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter();
//        http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);

//        final CustomBasicAuthenticationFilter customBasicAuthFilter = new CustomBasicAuthenticationFilter(this.authenticationManager() );
//        http.addFilter(customBasicAuthFilter);

        http.authorizeRequests()
                .antMatchers("/leader/**")
                .access("hasRole('ROLE_LEADER')")
                .antMatchers("/welcome", "/app/**", "/ticketapp/**", "/ticket/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/app")
                .failureForwardUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
//                .cors().disable()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder(11);}

}
