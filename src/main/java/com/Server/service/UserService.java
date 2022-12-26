package com.Server.service;

import com.API.domain.Personal;
import com.API.domain.Role;
import com.API.domain.User;
import com.Server.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService{
    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @Autowired
    private UserRepos userRepos;


    public boolean checkUser(User user, String password){
        if(user.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean searchUser(String username){
        User userFromDb = userRepos.findByUsername(username);

        if (userFromDb != null) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addNewUser(String username, String password) {
        boolean userExists = searchUser(username);
        if (userExists) {
            return false;
        }

        User user = new User();

        user.setUsername(username);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(password);
        userRepos.save(user);

        return true;
    }

    public User findByUsername(String username) {
        return userRepos.findByUsername(username);
    }

    public User userCheck(User user){
        User userCheck = userRepos.findByUsername(user.getUsername());
        if((userCheck != null) && (user.getPassword().equals(userCheck.getPassword()))){
            return userCheck;
        }
        else{
            return null;
        }
    }
}
