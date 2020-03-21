package Ca4006;

import java.util.*;  

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
		int i = 0;
		System.out.println("ProductionLine Start");
		while( i < IncomingPlanes){
			// do stuff
			i++
		}
	}

}