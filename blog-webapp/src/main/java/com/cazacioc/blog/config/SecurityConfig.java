package com.cazacioc.blog.config;

import com.cazacioc.blog.authorization.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * Created by scorpion on 12.08.14.
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Resource(name="authService")
    private UserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("USER", "ADMIN");
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers(
                        "/entry/add",
                        "/entry/*/delete",
                        "/entry/*/comment/*/delete"
                ).hasRole("ADMIN")
                .antMatchers(
                        "/entry/*/comment/add"
                ).hasRole("USER")

                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/blog/login")
                .permitAll();

        http.logout()
                .logoutUrl("/blog/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
    }
}
