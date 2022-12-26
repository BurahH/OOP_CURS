package com.Server.service;

import com.API.domain.Message;
import com.API.domain.ParkingPlace;
import com.API.domain.Price;
import com.API.domain.User;
import com.Server.repos.MessageRepos;
import com.Server.repos.ParkingPlaceRepos;
import com.Server.repos.PriceRepos;
import com.Server.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParkingPlaceService {
    @Autowired
    private ParkingPlaceRepos parkingPlaceRepos;

    @Autowired
    private PriceRepos priceRepos;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private MessageRepos messageRepos;

    public List<ParkingPlace> findAll() {
        List<ParkingPlace> parkingPlaceList = parkingPlaceRepos.findAll();
        if(parkingPlaceList.size() == 0){
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

    public void buyParkingPlace(ParkingPlace parkingPlace) {
        User user = userRepos.getOne(parkingPlace.getUser().getId());
        Date date = parkingPlace.getEndDate();
        parkingPlace = parkingPlaceRepos.getOne(parkingPlace.getId());
        parkingPlace.setEndDate(date);
        parkingPlace.setUser(user);
        parkingPlaceRepos.save(parkingPlace);
        Message message = new Message();
        message.setAuthor("Системное сообщение");
        message.setMessage("Успешная покупка места под номером " + parkingPlace.getNumber() + " совершена. Аренда закончится в " + parkingPlace.getEndDate());
        message.setUser(parkingPlace.getUser());
        messageRepos.save(message);
    }

    public Boolean redactParkingPlace(ParkingPlace parkingPlace) {
        parkingPlace.setUser(parkingPlaceRepos.getOne(parkingPlace.getId()).getUser());
        parkingPlaceRepos.save(parkingPlace);
        return true;
    }
}
