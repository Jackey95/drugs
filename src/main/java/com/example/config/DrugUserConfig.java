package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DrugUserConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()
                .requestMatchers("/api").permitAll()
                .anyRequest().authenticated();

        httpSecurity.formLogin()
               .loginPage("/tologin")
                .usernameParameter("username")
               .passwordParameter("password")
                .loginProcessingUrl("/login")
                .permitAll();
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("role1").build();
        UserDetails user2 = User.withUsername("user1").password(passwordEncoder().encode("1234")).roles("role1").build();

        //添加进内存
        manager.createUser(user1);
        manager.createUser(user2);
        return manager;
    }
}
