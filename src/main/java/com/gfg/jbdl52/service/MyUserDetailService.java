package com.gfg.jbdl52.service;


import com.gfg.jbdl52.domain.MyUser;
import com.gfg.jbdl52.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

   @Autowired
    UserRepository repository;


   @Autowired
   PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<MyUser> user=repository.findByUsername(username);
       return user.orElseThrow(() ->new UsernameNotFoundException("No user found"));
    }

    public void addUser(MyUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
