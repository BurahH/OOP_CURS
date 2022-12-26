package com.Server.controller;

import com.API.domain.ParkingPlace;
import com.API.domain.User;
import com.Server.service.ParkingPlaceService;
import com.Server.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
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

    @Autowired
    private UserService userService;

    @GetMapping("/parking")
    public List<ParkingPlace> getParkingPlace(){
        return parkingPlaceService.findAll();
    }

    @PostMapping("/parking/buy")
    public Boolean buyParking(@RequestBody ParkingPlace parkingPlace){
        parkingPlaceService.buyParkingPlace(parkingPlace);
        return true;
    }

    @PostMapping("/parking/redact")
    public Boolean redactParkingPlace(@RequestBody ParkingPlace parkingPlace){
        User userNew = userService.findByUsername(parkingPlace.getUser().getUsername());
        if((userNew == null) || !BCrypt.checkpw(parkingPlace.getUser().getPassword(), userNew.getPassword()) || (!userNew.getRoles().contains("ADMIN"))){
            return false;
        }
        else{
            return parkingPlaceService.redactParkingPlace(parkingPlace);
        }
    }
}
