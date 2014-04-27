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
public class QueueOfCars extends Thread {
    private ArrayList<Car> cars = null;
    public QueueOfCars(){
        cars = new ArrayList<Car>();
    }
    
    public void run(){
        while(null != cars){
            for(int i = 0; i < cars.size(); ++i){
                long timeGone = System.currentTimeMillis() - cars.get(i).getStartTime();
                if(timeGone > cars.get(i).getWaitingTime()*1000){
                    cars.remove(i);
                    --i;
                }
            }
        }
    }
    
    public ArrayList<Car> getCars(){
        return cars;
    }
    
    public void setCars(ArrayList<Car> cars){
        this.cars = cars;
    }
    
    public boolean addCar(Car newCar){
        return cars.add(newCar);
    }
}
