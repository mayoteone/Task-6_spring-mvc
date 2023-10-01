package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getAllCars(@RequestParam(value = "count", defaultValue = "5") Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Model Y", 2022));
        cars.add(new Car("Dodge", "Ram TRX", 2021));
        cars.add(new Car("Chevrolet", "Camaro", 2014));
        cars.add(new Car("Kia", "K5", 2023));
        cars.add(new Car("Mercedes", "CLA", 2020));

        List<Car> carsListNew = carService.getCars(count, cars);
        model.addAttribute("cars", carsListNew);

        return "cars";
    }
}
