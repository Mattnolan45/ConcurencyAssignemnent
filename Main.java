package Ca4006;

import java.util.*;  
import Ca4006.*;


public class Main{

  public static void main(String[] args) {

    Queue<Aircraft> WaitingProduction = new LinkedList<Aircraft>();

    AircraftWaitingList waitingList = new AircraftWaitingList();

    System.out.println("ProductionLine Start");
    Thread productionLine = new Thread( new ProductionLine(10, waitingList) );
    productionLine.start();

    System.out.println("AircraftControllor Start");
    Thread controllor = new Thread( new AircraftControllor(waitingList) );
    controllor.start();


  }

}