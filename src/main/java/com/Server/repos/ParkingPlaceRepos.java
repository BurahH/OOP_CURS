package com.Server.repos;

import com.API.domain.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParkingPlaceRepos extends JpaRepository<ParkingPlace, Long> {
}
