package Ca4006;

import java.util.*;  
import Ca4006.*;

public class AircraftWaitingList{
	private Queue<Aircraft> WaitingList; // shared resource


	public AircraftWaitingList(){
		this.WaitingList = new LinkedList<Aircraft>();
	}

	public synchronized Aircraft GetFromAircraftContollor(){ // removing from queue
		try { 
			wait();
		} catch (Exception e) {

		}
		
		return WaitingList.poll();
	}

	public synchronized void PutIntoProduction(Aircraft aircraft){ // adding to queue
		try{
			WaitingList.add(aircraft);
			notify();
		} catch( Exception e){

		}	
	}

	public int size(){
		return WaitingList.size();
	}

}

