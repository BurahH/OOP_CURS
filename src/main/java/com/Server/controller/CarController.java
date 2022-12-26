package com.Server.controller;

import com.API.domain.Car;
import com.API.domain.User;
import com.Server.service.CarService;
import com.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @PostMapping("/car")
    public User newCar(@RequestBody Car car){
        User user = userService.findByUsername(car.getUser().getUsername());
        car.setUser(user);
        carService.savePhone(car);
        return user;
    }

    @PostMapping("/car/find")
    public List<Car> getCar(@RequestBody User user){
        return carService.findByUser(user);
    }

    @PostMapping("/car/delete")
    public Boolean deleteCar(@RequestBody Car car){
        carService.deleteCar(car);
        return true;
    }
}
