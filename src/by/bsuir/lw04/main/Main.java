/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.main;

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
        CarPark2 carPark = new CarPark2(5);
        carPark.start();
        Random random = new Random();
        for(int i = 0; i < 10; ++i){
            Car2 car = new Car2(i,carPark);
            car.start();
        }
        while(true){
            
        }
    }
}
