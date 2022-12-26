package com.Server.service;

import com.API.domain.Personal;
import com.API.domain.User;
import com.Server.repos.PersonalRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {
    @Autowired
    private PersonalRepos personalRepos;

    public void personalSave(Personal personal){
        personalRepos.save(personal);
    }

    public Personal findByUser(User user) {
        return personalRepos.findByUser(user);
    }
}
