/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entity;

/**
 *
 * @author Anna
 */
public class CarPlace {
    private boolean free = true;
    public boolean isFree(){
        return free;
    }
    
    public void setFree(boolean isFree){
        free = isFree;
    }
}
