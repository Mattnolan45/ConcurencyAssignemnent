package Ca4006;

import java.util.*;  
import Ca4006.*;


public class Main{

  public static void main(String[] args) {
    System.out.println("This is my package!");
    
    Thread productionLine = new Thread( new ProductionLine(10) );
    productionLine.start();

    for(int i =0; i<5; i++){
    	Thread newAircraft = new Thread(new Aircraft(i));
    	newAircraft.start();
    }

    for(int i = 0; i<10; i++){

    	Thread testRobot = new Thread(new Robot(i));
    	testRobot.start(); 
 
    }

  }

}