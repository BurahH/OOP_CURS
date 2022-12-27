package com.Client;

import com.API.Service.ProfileService;
import com.API.domain.Phone;
import com.API.domain.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PhonesListModel extends AbstractListModel {
    private List<Phone> list = new ArrayList<>();
    private ProfileService profileService = new ProfileService();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }
    public void addPhone(User user, Phone phone){
        list = profileService.getPhone(user);
        fireIntervalAdded(phone, list.size() - 1, list.size() - 1);
    }
    public void addPhone(User user){
        list = profileService.getPhone(user);
    }
    public void deletePhone(User user, int index, ProfileService profileService) {
        Phone removePhone = list.remove(index);
        profileService.deletePhone(removePhone);
        fireIntervalRemoved(removePhone, index, index);
    }
    public void editPhone(User user, String number, int index, ProfileService profileService) {
        Phone phone = list.get(index);
        phone.setNumber(number);
        profileService.postPhone(user, phone);
        fireIntervalAdded(phone, index, index);
    }
}
