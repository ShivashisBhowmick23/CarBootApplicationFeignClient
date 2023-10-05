package com.boot.car.controller;


import com.boot.car.model.FeignCar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "CarFeign", url = "http://localhost:9000/car/myshowroom")
public interface OpenFeign {
    @PostMapping("/addCar")
    public FeignCar addCar(@RequestBody FeignCar car);

@GetMapping("/allCars")
    public List<FeignCar> viewAllCars();
}
