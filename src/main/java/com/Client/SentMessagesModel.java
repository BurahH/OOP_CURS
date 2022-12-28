package com.Client;

import com.API.Service.ProfileService;
import com.API.domain.Message;
import com.API.domain.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SentMessagesModel extends AbstractListModel {

    private List<Message> list = new ArrayList<>();

    private ProfileService profileService = new ProfileService();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }
    public void addMessage(User user){
        List<Message> list0 = profileService.getMessage(user);
        list.clear();
        for(Message mess : list0){
            if (mess.getAuthor().equals(user.getUsername()))
                list.add(mess);
        }
    }
    public void sentMessage(User user, Message message){
        profileService.postMessage(user , message, "admin");

        List<Message> list0 = profileService.getMessage(user);
        list.clear();
        for(Message mess : list0){
            if (mess.getAuthor().equals(user.getUsername()))
                list.add(mess);
        }
        fireIntervalAdded(message, list.size() - 1, list.size() - 1);
    }

}
