package com.Server.repos;

import com.API.domain.StoryRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRentRepos extends JpaRepository<StoryRent, Long> {
}
