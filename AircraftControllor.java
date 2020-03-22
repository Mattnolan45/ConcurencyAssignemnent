package Ca4006;

import java.util.*;  
import Ca4006.*;

public class AircraftControllor implements Runnable {
	private Queue<Aircraft> AircraftsWaitingForParts;
	private Storage PartStorage;
	private AircraftWaitingList WaitingProduction;
	
	public AircraftControllor(AircraftWaitingList waitingProduction){

		this.AircraftsWaitingForParts = new LinkedList<Aircraft>();
		this.PartStorage = new Storage();
		this.WaitingProduction = waitingProduction;

	}

	public Aircraft GenerateAircraft(int id){
		Aircraft newAircraft = new Aircraft(id);
		return newAircraft;
	}

	public synchronized boolean CheckParts(List<Part> aircraftWorkPlan){
		List<Part> storageCopy = PartStorage.GetStorageList();
		System.out.println("work: "+ aircraftWorkPlan);
		for(Part p : aircraftWorkPlan){
			
			for(Part storedPart : storageCopy){
				System.out.println("storedPart "+ storedPart.GetPartID());
				System.out.println("storageCopy "+ storageCopy);
				if(storedPart.GetPartID() == p.GetPartID()){
					try{
						int index = FindIndexInStorage(storageCopy, storedPart);
						storageCopy.remove(storageCopy.get(index));	
						System.out.println("Removed: "+ index);
					}catch(Exception e){
						return false;
					}
					
				}
				else{
					return false; // not all parts found
				}
			}
		}
		System.out.println("prnt true");
		return true; // all parts found
	}

	public int FindIndexInStorage(List<Part> parts, Part part){
		if(parts != null){
			int i = 0;
			while(i < parts.size()){
				System.out.println(parts.get(i).GetPartID());
				if(parts.get(i).GetPartID() == part.GetPartID()){
	
					return i;
				}
				else{
					i++;
				}
			}
		}
		return -1;
	}




	@Override
	public void run(){
		int aircraftCount = 0;
		while(aircraftCount <= 5 ){//|| !AircraftsWaitingForParts.isEmpty()){ // sync block wait/notify with check parts
			System.out.println("producing aircraft");
			if(aircraftCount <= 10 ){
				Aircraft arrivedAircraft = GenerateAircraft(aircraftCount); //  make new aircraft
				
				if(CheckParts(arrivedAircraft.getAricraftWorkPlan())){
					System.out.println("ready for production");
					WaitingProduction.PutIntoProduction(arrivedAircraft); //notify production line
				}
				else{
					AircraftsWaitingForParts.add(arrivedAircraft);// add to waiting list
				}

				// thread.sleep(random);  
				aircraftCount++;
			}else if (!AircraftsWaitingForParts.isEmpty()){
				// use poll for queue // check queue
			}


		}


	}


}
