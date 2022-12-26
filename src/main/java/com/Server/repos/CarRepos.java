package com.Server.repos;

import com.API.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepos extends JpaRepository<Car, Long> {
}
