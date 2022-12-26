package com.Server.repos;

import com.API.domain.Message;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepos extends JpaRepository<Message, Long> {
    List<Message> findByUser(User user);
}
