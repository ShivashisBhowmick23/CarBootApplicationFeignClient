package com.boot.car.controller;

import com.boot.car.model.FeignCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/FeignCar")
public class FeignCarController {

    private static final Logger logger = LoggerFactory.getLogger(FeignCarController.class);

    @Autowired
    OpenFeign oF;
    @Autowired
    Environment env;

    @PostMapping("/addCarIntoTheShowroom")
    public FeignCar addCar(@RequestBody FeignCar car) {
        logger.info("Port Number: " + env.getProperty("local.server.port"));
        return oF.addCar(car);
    }

    @GetMapping("/showAllCars")
    public List<FeignCar> viewAllCarsList() {
        logger.info("Port Number: " + env.getProperty("local.server.port"));
        return oF.viewAllCars();

    }

}