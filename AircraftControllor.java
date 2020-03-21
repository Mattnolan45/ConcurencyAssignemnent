package Ca4006;

import java.util.*;  
import Ca4006.*;

public class AircraftControllor implements Runnable {
	private Queue<Aircraft> AircraftsWaitingForParts;
	private Storage PartStorage;

	public AircraftControllor(){

		this.AircraftsWaitingForParts = new LinkedList<Aircraft>();
		this.PartStorage = new Storage();
	}

	public Aircraft GenerateAircraft(int id){
		Aircraft newAircraft = new Aircraft(id);
		return newAircraft;
	}

	public boolean CheckParts(List<Part> aircraftWorkPlan){
		List<Part> storageCopy = PartStorage.GetStorageList();
		for(Part p : aircraftWorkPlan){
			for(Part storedPart : storageCopy){
				if(storedPart == p){
					storageCopy.remove(FindIndexInStorage(storageCopy, storedPart));
				}
				else{
					return false; // not all parts found
				}
			}
		}
		return true; // all parts found
	}

	public int FindIndexInStorage(List<Part> parts, Part part){
		if(parts != null){
			int i = 0;
			while(i < parts.size()){
				if(parts.get(i) == part ){
					return i;
				}
				else{
					i++;
				}
			}
		}
		return -1;
	}

	public synchronized void ReadyForProduction(){

	}


	@Override
	public void run(){
		int aircraftCount = 0;
		while(aircraftCount <= 10 || !AircraftsWaitingForParts.isEmpty()){

			Aircraft arrivedAircraft = GenerateAircraft(aircraftCount);
			if(CheckParts(arrivedAircraft.getAricraftWorkPlan())){
				//ready for production
			}
			else{
				// add to waiting list
			}
			// thread.sleep();  
			aircraftCount++;

		}


	}


}
