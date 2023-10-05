package com.boot.car.controller;

import com.boot.car.model.FeignCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        logger.info("Executing ViewAllCarsList Method");
        return oF.viewAllCars();

    }

    @GetMapping("/sort-by-carmodels/{carModel}")
    public List<FeignCar> getCarsByCarModel(@PathVariable("carModel") String carModel) {
        logger.info("Port Number: " + env.getProperty("local.server.port"));
        logger.info("Executing getCarsByCarModel Method");
        return oF.getCarByModel(carModel);
    }

    @GetMapping("/sort-by-user-rating/{userRating}")
    public List<FeignCar> getCarsByUserRating(@PathVariable("userRating") int userRating) throws InterruptedException {
        logger.info("Port Number: " + env.getProperty("local.server.port"));
        logger.info("Executing getCarsByUserRating Method ");
        return oF.getCarbyUserRating(userRating);
    }

    @GetMapping("/sort-by-carId/{carId}")
    public List<Map<String, Object>> findCarsByCarId(@PathVariable("carId") String carId){
        logger.info("Port Number: "+env.getProperty("local.server.port"));
        logger.info("Executing findCarsByCarId Method");
        return oF.viewCarByCarId(carId);

    }
@GetMapping("/sort-by-color/{carColor}")
    public List<FeignCar> findCarByColor(@PathVariable("carColor") String carColor) throws InterruptedException {
        logger.info("Port Number: "+env.getProperty("local.server.port"));
        logger.info("Executing findCarByColor Method ");
        return oF.findCarsByColor(carColor);
    }


}
