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
public class CarPark {
    private ArrayList<CarPlace> carPlaces;
    public CarPark(int placeNumber){
        carPlaces = new ArrayList<CarPlace>();
        for(int i = 0; i < placeNumber; ++i)
            carPlaces.add(new CarPlace());
    }
    
    public ArrayList<CarPlace> getCarPlaces(){
        return carPlaces;
    }
    
    public CarPlace getFreeCarPlace(){
        for(CarPlace place:carPlaces){
            if(place.isFree()){
                place.setFree(false);
                return place;
            }                
        }
        return null;
            
    }
}
