/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.main;

import by.bsuir.lw04.constant.ThreadConstant;
import by.bsuir.lw04.entity.Car;
import by.bsuir.lw04.entity.CarPark;
import by.bsuir.lw04.entitysecond.Car2;
import by.bsuir.lw04.entitysecond.CarPark2;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Anna
 */
public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark(ThreadConstant.CAR_PARK_SIZE);
        carPark.start();
        Random random = new Random();
        for(int i = 0; i < ThreadConstant.CAR_NUMBER; ++i){
            Car car = new Car(random.nextInt(ThreadConstant.MAX_NUMBER_WAITING_TIME),carPark);
            car.start();
        }
        carPark.close();
    }
}
