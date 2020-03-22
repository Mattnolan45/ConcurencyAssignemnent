package Ca4006;

import java.util.*;  
import Ca4006.*;


public class Main{

  public static void main(String[] args) {

    Queue<Aircraft> WaitingProduction = new LinkedList<Aircraft>();

    AircraftWaitingList waitingList = new AircraftWaitingList();
    InProductionList inProductionList = new InProductionList();

    // start producitonLine
    System.out.println("ProductionLine Start");
    Thread productionLine = new Thread( new ProductionLine(10, waitingList,inProductionList) );
    productionLine.start();
    System.out.println();

    // start aircraft controller
    System.out.println("AircraftController Start");
    Thread aircraftControllor = new Thread( new AircraftController(waitingList) );
    aircraftControllor.start();
    System.out.println();

    // start robot controller
    System.out.println("RobotController Start");
    Thread robotControllor = new Thread( new RobotController( inProductionList ) );
    robotControllor.start();
    System.out.println();
  }

}