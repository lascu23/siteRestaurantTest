package com.example.SiteRestaurant.security;

import com.example.SiteRestaurant.entities.Client;
import com.example.SiteRestaurant.entities.Roles;
import com.example.SiteRestaurant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsernameAndPwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Client person = clientRepository.readByEmail(email);
        if(null!= person && person.getPersonId()>0 && passwordEncoder.matches(pwd, person.getPwd()))
            return new UsernamePasswordAuthenticationToken(person.getName(), null, getGrantedAuthorities(person.getRoles()));
        else
            throw new BadCredentialsException("Invalid credentials!!!");
    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
