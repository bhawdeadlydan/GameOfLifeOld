package com.gameoflife;
import java.util.Scanner;

import static java.lang.Thread.*;

public class Grid {
    private Cell[][] gridOfLife = new Cell[5][5];



    public Grid(){
        for(int i=0; i<5; i++)
            for (int j = 0; j < 5; j++)
                gridOfLife[i][j] = new Cell(false);
    }

    public void getInputCoordinates(){

        System.out.println(" enter choice -1 to end ");
        int input;
        input = new Scanner(System.in).nextInt();

        int inputX = 0;
        int inputY;
        while(input!=-1)
        {
            System.out.println("Enter x coordinate ");
            inputX = new Scanner(System.in).nextInt();

            System.out.println("Enter y coordinate ");
            inputY = new Scanner(System.in).nextInt();

            gridOfLife[inputX][inputY].setLifeStatus(true);

            System.out.println(" enter choice -1 to end ");
            input = new Scanner(System.in).nextInt();

        }
    }

    public static void main(String args[]) throws InterruptedException {
        Grid gd = new Grid();

        gd.getInputCoordinates();


        gd.showOutput();

        for(int i =0; i>=0 ;i++){
            System.out.print("\n\n");
            gd.iterate();
            gd.showOutput();
            sleep(250);

        }

    }

    private void showOutput() {
        for(int i =0 ;i <5 ; i++){
            for(int j = 0; j< 5 ; j++){
                if(gridOfLife[i][j].getLifeStatus())
                    System.out.print("*");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
    }


    public void iterate(){

        for(int i = 0 ; i <5 ; i++){
            for(int j =0; j<5 ; j++)
                updateLife(gridOfLife[i][j], i, j);
        }
    }

    public void updateLife( Cell cell, int posX, int posY){

        if (cell.getLifeStatus()) {
            if(getNeighbourCount(posX, posY) < 2)
                cell.setLifeStatus(false);
            else if(getNeighbourCount(posX,posY) > 3)
                cell.setLifeStatus(false);
            else
                cell.setLifeStatus(true);

        } else {
            if(getNeighbourCount(posX,posY) == 3)
                cell.setLifeStatus(true);
        }


    }

    private int getNeighbourCount(int posX, int posY) {
        int count=0;
        for(int i=-1; i<=1 ; i++){
            for(int j=-1; j<=1; j++){
                if(!((i==0)&&(j==0))) {
                    if (isValid(posX + i, posY + j)) {
                        if (gridOfLife[posX + i][posY + j].getLifeStatus()) {
                            count++;
                        }

                    }
                }

            }
        }
        return count;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i <= 4) && (j >= 0 && j <= 4);
    }
}
