package com.gfg.jbdl52.service.resource;

import com.gfg.jbdl52.domain.MyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private boolean isAdmin;

    public MyUser toUser(){
        return MyUser.builder().username(this.username).password(this.password).authorities(this.isAdmin?"admin":"user").build();
    }
}
