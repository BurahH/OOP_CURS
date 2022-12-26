package com.Server.repos;

import com.API.domain.Car;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CarRepos extends JpaRepository<Car, Long> {
    List<Car> findByUser(User user);
}
