package com.Server.repos;

import com.API.domain.StoryRent;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRentRepos extends JpaRepository<StoryRent, Long> {
    List<StoryRent> findByUser(User user);
}
