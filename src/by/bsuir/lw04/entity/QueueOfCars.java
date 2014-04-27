/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entity;

import java.util.ArrayList;

/**
 *
 * @author Anna
 */
public class QueueOfCars {
    private ArrayList<Car> cars = null;
    public QueueOfCars(){
        cars = new ArrayList<Car>();
    }
    
    public ArrayList<Car> getCars(){
        return cars;
    }
    
    public void addCar(Car newCar){
        cars.add(newCar);
    }
}
