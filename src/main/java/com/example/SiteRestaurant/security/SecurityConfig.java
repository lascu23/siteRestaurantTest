package com.example.SiteRestaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().ignoringRequestMatchers("/saveEmployee").ignoringRequestMatchers("/login").ignoringRequestMatchers("/createUser").and().authorizeHttpRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/static/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/order").authenticated()
                .requestMatchers("/dataBase").hasRole("ADMIN")
                .requestMatchers("/orders").hasRole("ADMIN")
                .requestMatchers("/departments").hasRole("ADMIN")
                .requestMatchers("/addEmployee").hasRole("ADMIN")
                .requestMatchers("/saveEmployee").hasRole("ADMIN")
                .requestMatchers("/deleteEmployee").hasRole("ADMIN")
                .requestMatchers("/updateEmployee").hasRole("ADMIN")
                .requestMatchers("/employees").hasRole("ADMIN")
                .requestMatchers("/").permitAll()
                .requestMatchers("").permitAll()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/logout").authenticated()
                .requestMatchers("/createUser").permitAll()
                .requestMatchers("/register").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("54321")
//                .roles("USER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }



}
