package Ca4006;

import java.util.*;  
import Ca4006.*;


public class Main{

  public static void main(String[] args) {
    System.out.println("ProductionLine Start");
    Thread productionLine = new Thread( new ProductionLine(10) );
    productionLine.start();

  }

}