/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.bsuir.lw04.entitysecond;

import by.bsuir.lw04.entitysecond.*;

/**
 *
 * @author Anna
 */
public class CarPlace {
    private boolean free = true;

    public boolean isFree(){
        return free;
    }
    
    public synchronized void setFree(boolean isFree){
        free = isFree;
    }
}
