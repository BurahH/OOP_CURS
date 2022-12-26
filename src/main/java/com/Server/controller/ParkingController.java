package com.Server.controller;

import com.API.domain.ParkingPlace;
import com.Server.service.ParkingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    private ParkingPlaceService parkingPlaceService;

    @GetMapping("/Parking")
    public List<ParkingPlace> getParkingPlace(){
        return parkingPlaceService.findAll();
    }
}
