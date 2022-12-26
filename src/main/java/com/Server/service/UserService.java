package com.Server.service;

import com.API.domain.Role;
import com.API.domain.User;
import com.Server.repos.UserRepos;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

        password = BCrypt.hashpw (password, BCrypt.gensalt());

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
        if((userCheck != null) && (BCrypt.checkpw(user.getPassword(), userCheck.getPassword()))){
            return userCheck;
        }
        else{
            return null;
        }
    }

    public List<User> getUser() {
        return userRepos.findAll();
    }

    public void redactUser(User user) {
        if(user.checkPassword()){
            user.setPassword(BCrypt.hashpw (user.getPassword(), BCrypt.gensalt()));
        }
        userRepos.save(user);
    }

    public User findById(Long id) {
        return userRepos.getOne(id);
    }
}
