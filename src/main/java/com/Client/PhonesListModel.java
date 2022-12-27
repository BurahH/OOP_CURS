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

    public void addPhone(Phone phone){
        list.add(phone);
        fireIntervalAdded(phone, list.size() - 1, list.size() - 1);
    }
    public void deletePhone(int index, ProfileService profileService) {
        Phone removePhone = list.remove(index);
        profileService.deletePhone(removePhone);
        fireIntervalRemoved(removePhone, index, index);
    }
    public void editPhone(User user, String number, int index, ProfileService profileService) {
        List<Phone> list0 = profileService.getPhone(user);
        Phone phone = list0.get(index);
        list = list0;
        phone.setNumber(number);
        profileService.postPhone(user, phone);
        fireIntervalAdded(phone, index, index);
    }
}
