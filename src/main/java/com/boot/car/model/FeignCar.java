package com.boot.car.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeignCar {
    private String carId;

    private String carName;

    private String carModel;

    private String carType;

    private double carPrice;

    private int userRating;

    private String carColor;

}
