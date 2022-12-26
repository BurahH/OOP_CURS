package com.Server.controller;

import com.API.domain.Message;
import com.API.domain.Personal;
import com.API.domain.Phone;
import com.API.domain.User;
import com.Server.service.MessageService;
import com.Server.service.PersonalService;
import com.Server.service.PhoneService;
import com.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/personal")
    public User setPersonal(@RequestBody Personal personal, UriComponentsBuilder builder){
        User user = userService.findByUsername(personal.getUser().getUsername());
        personal.setUser(user);
        personalService.personalSave(personal);
        return user;
    }

    @PostMapping("/personal/find")
    public Personal getPersonal(@RequestBody User user, UriComponentsBuilder builder){
        return personalService.findByUser(user);
    }

    @PostMapping("/phone")
    public User setPhone(@RequestBody Phone phone, UriComponentsBuilder builder){
        User user = userService.findByUsername(phone.getUser().getUsername());
        phone.setUser(user);
        phoneService.savePhone(phone);
        return user;
    }

    @PostMapping("/phone/find")
    public List<Phone> getPhone(@RequestBody User user){
        return phoneService.findByUser(user);
    }

    @PostMapping("/phone/delete")
    public Boolean deletePhone(@RequestBody Phone phone){
        phoneService.deletePhone(phone);
        return true;
    }

    @PostMapping("/message")
    public Boolean setMessage(@RequestBody Message message, UriComponentsBuilder builder){
        User user = userService.findByUsername(message.getUser().getUsername());
        message.setAuthor(user.getUsername());
        user = userService.findByUsername(message.getAuthor());
        if(user == null){
            return false;
        }
        message.setUser(user);
        messageService.saveMessage(message);
        return true;
    }

    @PostMapping("/message/find")
    public List<Message> getMessage(@RequestBody User user){
        return messageService.findByUser(user);
    }

    @PostMapping("/message/delete")
    public Boolean deleteMessage(@RequestBody Message message){
        messageService.deleteMessage(message);
        return true;
    }
}
