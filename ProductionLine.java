package Ca4006;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;  
import Ca4006.*;

public class ProductionLine implements Runnable{
	private int IncomingPlanes;
	private Queue<Aircraft> InProduction;
	private AircraftWaitingList WaitingProduction;

	public ProductionLine(int maxplanes, AircraftWaitingList waitingProduction){
		this.IncomingPlanes = maxplanes;
		this.InProduction = new LinkedList<Aircraft>();
		this.WaitingProduction = waitingProduction;
	}


	

	@Override 
	public void run(){


		System.out.println("Thread Pool Started");
		//ExecutorService pool = Executors.newFixedThreadPool(10); // starts thread pool
		while(true){
			if(InProduction.size() < 3){
				Aircraft readyAircraft = WaitingProduction.GetFromContollor(); 
				readyAircraft.print();	
			}

			
			//check waiting in production
			//do production
		}
	}
}