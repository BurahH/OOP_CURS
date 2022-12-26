package com.Server.timer;

import com.API.domain.ParkingPlace;
import com.Server.repos.ParkingPlaceRepos;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

@Component
public class ParkingTimer {
    @Autowired
    private ParkingPlaceRepos parkingPlaceRepos;

    @Scheduled(fixedDelay = 60000)
    public void checkDate() throws IOException {
        //String TIME_SERVER = "time-a.nist.gov";    //TODO Неправильное использование времени
        //NTPUDPClient timeClient = new NTPUDPClient();
        //InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        //TimeInfo timeInfo = timeClient.getTime(inetAddress);
        //long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        Date date = new Date();
        List<ParkingPlace> parkingPlaces = parkingPlaceRepos.findByEndTimeLessThan(date);
        for(ParkingPlace parkingPlace : parkingPlaces){
            parkingPlace.setUser(null);
            parkingPlace.setEndDate(null);
            parkingPlaceRepos.save(parkingPlace);
        }
    }
}
