package Ca4006;


import java.util.*;  
import Ca4006.*;

public class ProductionLine implements Runnable{
	private int IncomingPlanes;
	private InProductionList InProduction;
	private AircraftWaitingList WaitingProduction;

	public ProductionLine(int maxplanes, AircraftWaitingList waitingProduction,InProductionList inProductionList ){
		this.IncomingPlanes = maxplanes;
		this.InProduction = inProductionList;
		this.WaitingProduction = waitingProduction;
	}

	public void CheckForSpaceInProductionLine(){
		System.out.println("Production size: "+InProduction.size());
		if(InProduction.size() <= 3){
				
				Aircraft readyAircraft = WaitingProduction.GetFromAircraftContollor(); 
				readyAircraft.print();
				
				System.out.println("Sending Aircraft: "+readyAircraft.getAircraftId()+" into ProductionLine");
				InProduction.PutIntoProductionList(readyAircraft);
				
				System.out.println();
		}
	}

	

	@Override 
	public void run(){	
		while(true){
			CheckForSpaceInProductionLine();

			System.out.println("Aircrafts Waiting to go to InProduction: " + WaitingProduction.size());
			System.out.println();
			try{
				Thread.sleep(1000);
			}
			catch(Exception e ){
				System.out.println(e);
			}
		}


	}
}