package Ca4006;

import java.util.*;  

public class ProductionLine implements Runnable{
	private int MaxPlanes;
	private Queue<Aircraft> InProduction;
	private Queue<Aircraft> WaitingProduction;

	public ProductionLine(int productionCap){
		this.MaxPlanes = productionCap;
		this.InProduction = new LinkedList<Aircraft>();
		this.WaitingProduction = new LinkedList<Aircraft>();
	}


	@Override 
	public void run(){

		System.out.println("ProductionLine Start");
		while( !InProduction.isEmpty() && !WaitingProduction.isEmpty()){


		}

	}

}