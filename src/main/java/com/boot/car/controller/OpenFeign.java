package com.boot.car.controller;


import com.boot.car.model.FeignCar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "CarFeign", url = "http://localhost:9000/car/myshowroom")
public interface OpenFeign {
    @PostMapping("/addCar")
    public FeignCar addCar(@RequestBody FeignCar car);

    @GetMapping("/allCars")
    public List<FeignCar> viewAllCars();

    @GetMapping("/getByModel/{carModel}")
    public List<FeignCar> getCarByModel(@PathVariable("carModel") String carModel);

    @GetMapping("/getCarbyUserRating/{userRating}")
    public List<FeignCar> getCarbyUserRating(@PathVariable("userRating") int userRating) throws InterruptedException;

    @GetMapping("/getCarByCarId/{carId}")
    public List<Map<String, Object>> viewCarByCarId(@PathVariable("carId") String carid);

    @GetMapping("/findCar/carColor/{carColor}")
    public List<FeignCar> findCarsByColor(@PathVariable("carColor") String carColor) throws InterruptedException;

}

