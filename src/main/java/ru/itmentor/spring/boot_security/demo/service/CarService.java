package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.model.CarModel;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<CarModel> cars;
    public CarService() {
        cars = new ArrayList<>();
        cars.add(new CarModel("Auto1","Color1",2000));
        cars.add(new CarModel("Auto2","Color2",2021));
        cars.add(new CarModel("Auto3","Color1",2022));
        cars.add(new CarModel("Auto4", "Color3",2023));
        cars.add(new CarModel("Auto5","Color1",2024));
    }
    public List<CarModel> getCars(int count ) {
        if (count > cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}