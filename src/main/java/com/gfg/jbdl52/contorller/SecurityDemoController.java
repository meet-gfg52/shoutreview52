package com.gfg.jbdl52.contorller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {


    @GetMapping("/greet/{user}")
    public ResponseEntity<?> greetUser(@PathVariable String user){
        return new ResponseEntity<>("hello "+user, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/greet/admin/{user}")
    public ResponseEntity<?> greetUserAdmin(@PathVariable String user){
        return new ResponseEntity<>("hello "+user, HttpStatusCode.valueOf(200));
    }
}
