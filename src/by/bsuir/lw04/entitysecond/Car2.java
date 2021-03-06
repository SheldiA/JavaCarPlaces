/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entitysecond;

import by.bsuir.lw04.constant.ThreadConstant;
import static java.lang.Thread.sleep;

/**
 *
 * @author Anna
 */
public class Car2 extends Thread{
    private int waitingTime;
    private long startTime;
    private CarPlace2 carPlace;
    private CarPark2 carPark;
    
    public Car2(int time,CarPark2 carPark){
        waitingTime = time;
        this.carPark = carPark;
        startTime = System.currentTimeMillis();
    }
    
    public void run(){
        carPark.addToQueue(this);
        long timeSpan = System.currentTimeMillis() - startTime;
        while(carPlace == null && timeSpan < waitingTime*1000){
            try{
                sleep(ThreadConstant.WAITING_MS_IN_WAITING_CAR_PLACE);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            timeSpan = System.currentTimeMillis() - startTime;
        }
        useCarPlace();
    }
    
    public int getWaitingTime(){
        return waitingTime;
    }
    
    public long getStartTime(){
        return startTime;
    }
    
    public CarPlace2 getCarPlace(){
        return carPlace;
    }
    
    public void setCarPlace(CarPlace2 carPlace){
        this.carPlace = carPlace;
    }
    
    public void useCarPlace(){
        if(null != carPlace){
            try{
                sleep(ThreadConstant.WAITING_MS_IN_USING_CAR);
                System.out.println("finish using car with time "+ getWaitingTime());
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
            carPark.returnCarPlace(carPlace);
        }
        else
            System.out.println("null car place for car with time "+ getWaitingTime());
    }
}
