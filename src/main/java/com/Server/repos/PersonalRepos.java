package com.Server.repos;

import com.API.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepos extends JpaRepository<Personal, Long> {
}
