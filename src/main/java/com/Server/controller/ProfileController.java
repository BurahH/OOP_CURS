package com.Server.controller;

import com.API.domain.Personal;
import com.API.domain.User;
import com.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProfileController {
    @Autowired
    private UserService userService;

    @GetMapping("/personal")
    public Personal setPersonal(@RequestBody Personal personal, UriComponentsBuilder builder){
        return personal;
    }
}
