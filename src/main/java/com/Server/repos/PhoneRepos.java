package com.Server.repos;

import com.API.domain.Phone;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepos extends JpaRepository<Phone, Long> {
    List<Phone> findByUser(User user);
}
