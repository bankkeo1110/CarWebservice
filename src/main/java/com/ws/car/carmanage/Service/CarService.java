package com.ws.car.carmanage.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ws.car.carmanage.entity.Car;
@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        // Initialize with some sample data
        cars.add(new Car(1L, "Toyota", "Corolla", 2020));
        cars.add(new Car(2L, "Ford", "Mustang", 2021));
        cars.add(new Car(3L, "Tesla", "Model S", 2022));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public Car getCarById(Long id) {
        return cars.stream()
                   .filter(car -> car.getId().equals(id))
                   .findFirst()
                   .orElse(null);
    }

    public Car addCar(Car car) {
        car.setId((long) (cars.size() + 1)); // Simple ID generation strategy
        cars.add(car);
        return car;
    }

    public Car updateCar(Long id, Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                updatedCar.setId(id);
                cars.set(i, updatedCar);
                return updatedCar;
            }
        }
        return null;
    }

    public boolean deleteCar(Long id) {
        return cars.removeIf(car -> car.getId().equals(id));
    }
}
