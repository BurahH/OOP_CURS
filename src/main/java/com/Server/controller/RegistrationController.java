package com.Server.controller;

import com.API.domain.User;
import com.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public Boolean registration(@RequestBody User user, UriComponentsBuilder builder) {
        boolean check = userService.addNewUser(user.getUsername(), user.getPassword());
        return check;
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user, UriComponentsBuilder builder) {
        User userCheck = userService.userCheck(user);
        return userCheck;
    }

}
