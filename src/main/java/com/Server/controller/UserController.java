package com.Server.controller;

import com.API.domain.Role;
import com.API.domain.User;
import com.Server.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public List<User> getUser(@RequestBody User user){
        User userNew = userService.findByUsername(user.getUsername());
        if((userNew == null) || !BCrypt.checkpw(user.getPassword(), userNew.getPassword()) || (!userNew.getRoles().contains(Role.ADMIN))){
            return null;
        }
        else{
            return userService.getUser();
        }
    }

    @PostMapping("/user/redact")
    public Boolean redactUser(@RequestBody User user){
        userService.redactUser(user);
        return true;
    }
}
