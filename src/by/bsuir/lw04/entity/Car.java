/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Anna
 */
public class Car {
    private int waitingTime;
    private long startTime;
    private CarPlace carPlace;
    public Car(int time){
        waitingTime = time;
        startTime = System.currentTimeMillis();
    }
    
    public int getWaitingTime(){
        return waitingTime;
    }
    
    public long getStartTime(){
        return startTime;
    }
    
    public CarPlace getCarPlace(){
        return carPlace;
    }
    
    public void setCarPlace(CarPlace carPlace){
        this.carPlace = carPlace;
    }
}
