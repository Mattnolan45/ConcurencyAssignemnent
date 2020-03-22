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
		int aircraftCount = 1;
		while(aircraftCount <= 6  ){ 
			System.out.println("Making aircraft Number: " + aircraftCount);
			System.out.println();
			if(aircraftCount <= 6 ){

				Aircraft arrivedAircraft = GenerateAircraft(aircraftCount); //  make new aircraft
				WaitingProduction.PutIntoProduction(arrivedAircraft); // put into shared waiting production list
				
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println(e);
				}
			}
			aircraftCount++;
		}
		System.out.println("AircraftController closed"); // all aircrafts have been made and added into the waiting list
		System.out.println();

	}


}
