/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.main;

import by.bsuir.lw04.entity.Car;
import by.bsuir.lw04.entity.QueueOfCars;
import java.util.ArrayList;

/**
 *
 * @author Anna
 */
public class Main {
    public static void main(String[] args) {
        QueueOfCars qc = new QueueOfCars();
        ArrayList<Car> cars = qc.getCars();
        boolean b = qc.addCar(new Car(5));
        qc.addCar(new Car(10));
        qc.addCar(new Car(15));
        qc.start();
        qc.setCars(null);
    }
}
