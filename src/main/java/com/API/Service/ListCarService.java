package com.API.Service;

import com.API.domain.Car;
import com.API.domain.Phone;
import com.API.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ListCarService {
    public User postCar(User user, Car car) {        //отправка нового автомобиля на сервер
        car.setUser(user);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/car";

        HttpEntity<Car> request = new HttpEntity<Car>(car);

        ResponseEntity<User> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }

    public List<Car> getCar(User user) {        //получение автомобилей пользователя
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/car/find";

        HttpEntity<User> request = new HttpEntity<User>(user);

        ResponseEntity<List<Car>> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , new ParameterizedTypeReference<List<Car>>(){});

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }
        System.out.println(response.getBody());
        return response.getBody();
    }

    public Boolean deleteCar(Car car) {            //удаление конкретного автомобиля пользователя
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/car/delete";

        HttpEntity<Car> request = new HttpEntity<Car>(car);

        ResponseEntity<Boolean> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request , Boolean.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
        } else {
            System.out.println(response.getStatusCode());
        }

        return response.getBody();
    }
}
