package com.Server.repos;

import com.API.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepos extends JpaRepository<Message, Long> {
}