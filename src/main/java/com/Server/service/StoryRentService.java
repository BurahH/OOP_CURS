package com.Server.service;

import com.API.domain.StoryRent;
import com.API.domain.User;
import com.Server.repos.StoryRentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryRentService {
    @Autowired
    private StoryRentRepos storyRentRepos;

    public List<StoryRent> getStory(User user) {
        return storyRentRepos.findByUser(user);
    }
}
