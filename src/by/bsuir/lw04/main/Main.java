/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.main;

import by.bsuir.lw04.entity.Car;
import by.bsuir.lw04.entity.CarPark;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Anna
 */
public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark(5);
        carPark.start();
        Random random = new Random();
        for(int i = 0; i < 10; ++i){
            Car car = new Car(i,carPark);
            car.start();
        }
        while(true){
            
        }
    }
}
