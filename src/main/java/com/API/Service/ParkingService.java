package com.API.Service;

import com.API.domain.Car;
import com.API.domain.ParkingPlace;
import com.API.domain.User;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ParkingService {
    public List<ParkingPlace> getParkingPlace() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/parking";

        ResponseEntity<List<ParkingPlace>> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, null , new ParameterizedTypeReference<List<ParkingPlace>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }
        System.out.println(response.getBody());
        return response.getBody();
    }

    public Boolean buyParkingPlace(ParkingPlace parkingPlace, User user, int month){
        //String TIME_SERVER = "time-a.nist.gov";        //TODO Неправильное использование времени
        //NTPUDPClient timeClient = new NTPUDPClient();
        //InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        //TimeInfo timeInfo = timeClient.getTime(inetAddress);
        //long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        Date date1 = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, month);
        Date date = calendar.getTime();
        parkingPlace.setEndDate(date);
        parkingPlace.setUser(user);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/parking/buy";

        HttpEntity<ParkingPlace> request = new HttpEntity<ParkingPlace>(parkingPlace);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }
}
