package com.Server.service;

import com.API.domain.Message;
import com.API.domain.Phone;
import com.API.domain.User;
import com.Server.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepos messageRepos;
    
    public void saveMessage(Message message) {
        messageRepos.save(message);
    }

    public List<Message> findByUser(User user) {
        return messageRepos.findByUser(user);
    }

    public void deleteMessage(Message message) {
        Message dMessage = messageRepos.getOne(message.getId());
        messageRepos.delete(dMessage);
    }
}
