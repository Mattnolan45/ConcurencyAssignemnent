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

	public synchronized void PutIntoProduction(Aircraft goToProduction){
		if(InProduction.size() < 3){
			InProduction.add(goToProduction);
		}
	}

	

	@Override 
	public void run(){

		System.out.println("AircraftControllor Start");
    	Thread controllor = new Thread(new AircraftControllor());
    	controllor.start();
		synchronized(controllor){
			try{
				controllor.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}

		System.out.println("Thread Pool Started");
		//ExecutorService pool = Executors.newFixedThreadPool(10); // starts thread pool
		while(true){
			//check waiting in production
			//do production
		}
	}
}