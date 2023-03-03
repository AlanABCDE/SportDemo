package com.noob.sportsdemo.controller;

import com.noob.sportsdemo.entity.Car;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    @PostMapping("/car")
    public String Car(Car car){
        System.out.println(car);
        return "CarDetails";
    }
    @RequestMapping("/getcars")
    public String getCars(String car_id,String license,String car_stat){
        System.out.println("car_id"+car_id);
        System.out.println("license"+license);
        System.out.println("car_stat"+car_stat);
        return "getCars";
    }
}
