package Ca4006;

import java.util.*;  
import Ca4006.*;

public class AircraftController implements Runnable {
	private Queue<Aircraft> AircraftsWaitingForParts;
	private Storage PartStorage;
	private AircraftWaitingList WaitingProduction;
	
	public AircraftController(AircraftWaitingList waitingProduction){

		this.AircraftsWaitingForParts = new LinkedList<Aircraft>();
		this.PartStorage = new Storage();
		this.WaitingProduction = waitingProduction;

	}

	public Aircraft GenerateAircraft(int id){
		Aircraft newAircraft = new Aircraft(id);
		return newAircraft;
	}


	@Override
	public void run(){
		int aircraftCount = 0;
		while(aircraftCount <= 5 ){ //|| !AircraftsWaitingForParts.isEmpty()){ // sync block wait/notify with check parts
			System.out.println("Making aircraft Number: " + aircraftCount);
			if(aircraftCount <= 5 ){

				Aircraft arrivedAircraft = GenerateAircraft(aircraftCount); //  make new aircraft
				WaitingProduction.PutIntoProduction(arrivedAircraft);
				System.out.println("AircraftController Sleep");
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println(e);
				}
			}
			aircraftCount++;
		}
		System.out.println("AircraftController closed");

	}


}
