package com.Server.controller;

import com.API.domain.User;
import com.Server.repos.UserRepos;
import com.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class registrationController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public Boolean registration(@RequestBody User user, UriComponentsBuilder builder) {
        boolean check = userService.addNewUser(user.getUsername(), user.getPassword());
        return check;           //TODO возвращает true если успешная решитрация и false если не успешная
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user, UriComponentsBuilder builder) {
        User userCheck = userService.userCheck(user);
        return userCheck;  //TODO Возвращаяет пользователя со всеми данными (проверить зависимые классы)
    }

}
