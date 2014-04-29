/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entity;

import by.bsuir.lw04.constant.ThreadConstant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anna
 */
public class CarPark extends Thread{
    private ArrayList<CarPlace> carPlaces;
    private ArrayList<Car> waitingCars;
    
    public CarPark(int placeNumber){
        carPlaces = new ArrayList<CarPlace>();
        for(int i = 0; i < placeNumber; ++i)
            carPlaces.add(new CarPlace());
        waitingCars = new ArrayList<Car>();
    }
    
    public void run(){
        while(null != waitingCars){
            if(waitingCars.size() != 0){
                CarPlace carPlace = getFreeCarPlace();
                if(carPlace != null){
                    Car currCar = null;
                    synchronized(waitingCars){                        
                        currCar = waitingCars.get(0);
                        System.out.println("handle car with time "+currCar.getWaitingTime());
                        waitingCars.remove(0);
                        System.out.println("delete from queue car with time "+currCar.getWaitingTime());
                    }
                    if(null != currCar)
                        currCar.setCarPlace(carPlace);
                    
                }           
                
            }
        }
    }
    
    public void close(){
        while(waitingCars.size() != 0)
            try {
                sleep(ThreadConstant.WAITING_MS_IN_CLOSING_CAR_PARK);
            } catch (InterruptedException ex) {
                Logger.getLogger(CarPark.class.getName()).log(Level.SEVERE, null, ex);
            }
        waitingCars = null;
    }
    
    public ArrayList<CarPlace> getCarPlaces(){
        return carPlaces;
    }
    
    public void addToQueue(Car car){
        if(car.getCarPlace() == null){
            synchronized(waitingCars){
                waitingCars.add(car);
                System.out.println("add to queue car with time "+car.getWaitingTime());
            }
        }
    }
    
    public CarPlace getFreeCarPlace(){
        synchronized(carPlaces){
            for(CarPlace place:carPlaces){
                if(place.isFree()){
                    place.setFree(false);
                    return place;
                }                
            }
        }
        return null;                    
    }
    
    public void returnCarPlace(CarPlace carPlace){
        synchronized(carPlaces){
            if(null!= carPlace && null != carPlaces){
                carPlaces.get(carPlaces.indexOf(carPlace)).setFree(true);
            }
        }
    }
    
}
