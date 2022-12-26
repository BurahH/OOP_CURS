package com.Server.service;

import com.API.domain.Phone;
import com.API.domain.User;
import com.Server.repos.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepos phoneRepos;

    public void savePhone(Phone phone) {
        phoneRepos.save(phone);
    }

    public List<Phone> findByUser(User user) {
        return phoneRepos.findByUser(user);
    }

    public void deletePhone(Phone phone) {
        Phone dPhone = phoneRepos.getOne(phone.getId());
        phoneRepos.delete(dPhone);
    }
}
