/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entitysecond;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anna
 */
public class CarPark2 extends Thread{
    private ArrayList<CarPlace2> carPlaces;
    private ArrayList<Car2> waitingCars;
    private Semaphore waitingCarsSemaphore;
    private Semaphore carPlacesSemaphore;
    
    public CarPark2(int placeNumber){
        carPlaces = new ArrayList<CarPlace2>();
        for(int i = 0; i < placeNumber; ++i)
            carPlaces.add(new CarPlace2());
        waitingCars = new ArrayList<Car2>();
        waitingCarsSemaphore = new Semaphore(1);
        carPlacesSemaphore = new Semaphore(1);
    }
    
    public void run(){
        while(null != waitingCars){
            if(waitingCars.size() != 0){
                CarPlace2 carPlace = getFreeCarPlace();
                if(carPlace != null){
                    Car2 currCar = null;
                    try {
                        waitingCarsSemaphore.acquire();
                        currCar = waitingCars.get(0);
                        System.out.println("handle car with time "+currCar.getWaitingTime());
                        waitingCars.remove(0);
                        System.out.println("delete from queue car with time "+currCar.getWaitingTime());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CarPark2.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        waitingCarsSemaphore.release();
                    } 
                    if(null != currCar)
                        currCar.setCarPlace(carPlace);
                    
                }           
                
            }
        }
    }
    
    public ArrayList<CarPlace2> getCarPlaces(){
        return carPlaces;
    }
    
    public void addToQueue(Car2 car){
        if(car.getCarPlace() == null){
            try{
                waitingCarsSemaphore.acquire();
                waitingCars.add(car);
                System.out.println("add to queue car with time "+car.getWaitingTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(CarPark2.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                waitingCarsSemaphore.release();
            }
        }
    }
    
    public CarPlace2 getFreeCarPlace(){
        try {
            carPlacesSemaphore.acquire();
            for(CarPlace2 place:carPlaces){
                if(place.isFree()){
                    place.setFree(false);
                    System.out.println("busy car places");
                    return place;
                }                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CarPark2.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            carPlacesSemaphore.release();
        }          
        return null;                    
    }
    
    public void returnCarPlace(CarPlace2 carPlace){
        try {
            carPlacesSemaphore.acquire();
            if(null!= carPlace && null != carPlaces){
                System.out.println("free car places");
                carPlaces.get(carPlaces.indexOf(carPlace)).setFree(true);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CarPark2.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            carPlacesSemaphore.release();
        }
    }
    
}
