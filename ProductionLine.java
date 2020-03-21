package Ca4006;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;  
import Ca4006.*;

public class ProductionLine implements Runnable{
	private int IncomingPlanes;
	private Queue<Aircraft> InProduction;
	private Queue<Aircraft> WaitingProduction;

	public ProductionLine(int maxplanes){
		this.IncomingPlanes = maxplanes;
		this.InProduction = new LinkedList<Aircraft>();
		this.WaitingProduction = new LinkedList<Aircraft>();
	}



	@Override 
	public void run(){
		System.out.println("Thread Pool Started");
		ExecutorService pool = Executors.newFixedThreadPool(10);


		System.out.println("AircraftControllor Start");
		AircraftControllor controllor = new AircraftControllor();


		Queue<Robot> rbots = new LinkedList<Robot>();
    	for(int j = 0; j<10; j++){
        	Thread robot = new Thread(new Robot(j));
        	robot.start(); 
    	}
   	 

	}

}