package com.gameoflife;

public class Cell {
    private boolean Alive = false ;
    public Cell(boolean status){
        Alive = status;
    }
    public boolean getLifeStatus(){
        return Alive;
    }
    public void setLifeStatus(boolean status){
        Alive = status;
    }
}
