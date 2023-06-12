package com.gfg.jbdl52.contorller;

import com.gfg.jbdl52.domain.MyUser;
import com.gfg.jbdl52.service.MyUserDetailService;
import com.gfg.jbdl52.service.resource.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    MyUserDetailService myUserDetailService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        myUserDetailService.addUser(userRequest.toUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
