package com.Server.controller;

import com.API.domain.ParkingPlace;
import com.Server.service.ParkingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    private ParkingPlaceService parkingPlaceService;

    @GetMapping("/parking")
    public List<ParkingPlace> getParkingPlace(){
        return parkingPlaceService.findAll();
    }

    @PostMapping("/parking/buy")
    public Boolean buyParking(@RequestBody ParkingPlace parkingPlace){
        parkingPlaceService.buyParkingPlace(parkingPlace);
        return true;
    }
}
