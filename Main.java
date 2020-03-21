
package Ca4006;

import java.util.*;  
import Ca4006.*;


public class Main{

  public static void main(String[] args) {
    System.out.println("This is my package!");
    
    for(int i = 0; i<10; i++){

    	Thread testRobot = new Thread(new Robot(i));
    	testRobot.start(); 

    	Thread testAircraft = new Thread(new Aircraft(i));
    	testAircraft.start(); 
    }

  }

}