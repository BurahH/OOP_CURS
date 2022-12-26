package com.Server.repos;

import com.API.domain.Personal;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepos extends JpaRepository<Personal, Long> {
    Personal findByUser(User user);
}
