package com.Server.service;

import com.API.domain.Car;
import com.API.domain.User;
import com.Server.repos.CarRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepos carRepos;

    public void savePhone(Car car) {
        carRepos.save(car);
    }

    public List<Car> findByUser(User user) {
        return carRepos.findByUser(user);
    }

    public void deleteCar(Car car) {
        Car dCar = carRepos.getOne(car.getId());
        carRepos.delete(dCar);
    }
}
