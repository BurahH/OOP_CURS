package com.Client;

import com.API.Service.ListCarService;
import com.API.domain.Car;
import com.API.domain.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarsListModel extends AbstractListModel {

    private List<Car> list = new ArrayList<>();

    private ListCarService listCarService = new ListCarService();

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    public void addCar(User user, Car car){
        list = listCarService.getCar(user);
        fireIntervalAdded(car, list.size() - 1, list.size() - 1);
    }
    public void addCar(User user){
        list = listCarService.getCar(user);
    }

    public void deleteCar(ListCarService listCarService, int index) {
        Car removeCar = list.remove(index);
        listCarService.deleteCar(removeCar);
        fireIntervalRemoved(removeCar, index, index);
    }

    public void editCar(ListCarService listCarService, User user, String model, String number, int index) {
        Car car = list.get(index);
        car.setModel(model);
        car.setNumber(number);
        listCarService.postCar(user, car);
        fireIntervalAdded(car, index, index);
    }


}
