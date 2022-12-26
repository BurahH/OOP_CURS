package com.Server.repos;

import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepos extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
