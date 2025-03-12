package ru.itmentor.spring.boot_security.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmentor.spring.boot_security.demo.service.CarService;

@Slf4j
@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getListOfCars(@RequestParam(defaultValue = "5") int count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        log.info("Получено {} машин", count);
        return "cars";
    }
}