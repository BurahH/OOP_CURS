package com.Server.service;

import com.API.domain.ParkingPlace;
import com.API.domain.Price;
import com.Server.repos.ParkingPlaceRepos;
import com.Server.repos.PriceRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingPlaceService {
    @Autowired
    private ParkingPlaceRepos parkingPlaceRepos;

    @Autowired
    private PriceRepos priceRepos;

    public List<ParkingPlace> findAll() {
        List<ParkingPlace> parkingPlaceList = parkingPlaceRepos.findAll();
        if(parkingPlaceList == null){
            int i;
            Price price;
            Long number;
            for(i = 1; i < 25; i++){
                price = new Price(40000, 35000, 30000);
                priceRepos.save(price);
                number = Long.valueOf(i);
                parkingPlaceRepos.save(new ParkingPlace(number, price));
            }
        }
        for(ParkingPlace parkingPlace : parkingPlaceList){
            if(parkingPlace.haveUser()) {
                parkingPlace.getUser().setUsername(null);
                parkingPlace.getUser().setPassword(null);
                parkingPlace.getUser().getRoles().clear();
            }
        }
        return parkingPlaceRepos.findAll();
    }
}
