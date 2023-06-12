package com.gfg.jbdl52.config;

import com.gfg.jbdl52.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class MyAuthenticationManager implements AuthenticationProvider {

    @Autowired
    MyUserDetailService userDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name=authentication.getName();
        UserDetails userDetails=userDetailService.loadUserByUsername(name);
        //check -> account level checks
        if(passwordEncoder.matches(userDetails.getPassword(),authentication.getCredentials().toString()))
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),authentication.getCredentials(),userDetails.getAuthorities());
        else
            throw new BadCredentialsException("Invalid credentials");


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
