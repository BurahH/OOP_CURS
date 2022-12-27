package com.Server.repos;

import com.API.domain.ParkingPlace;
import com.API.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface ParkingPlaceRepos extends JpaRepository<ParkingPlace, Long> {
    List<ParkingPlace> findByEndDateLessThan(Date date);
    List<ParkingPlace> findByUser(User user);
}
