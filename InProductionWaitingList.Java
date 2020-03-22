package Ca4006;

import java.util.*;  
import Ca4006.*;

public class InProductionWaitingList{
	private Queue<Aircraft> InProductionList;


	public AircraftWaitingList(){
		this.InProductionList = new LinkedList<Aircraft>();
	}

	public synchronized Aircraft RemoveFromProductionLine(){
		try { 
			wait();
		} catch (Exception e) {

		}
		
		return WaitingList.poll();
	}

	public synchronized void PutIntoProduction(Aircraft aircraft){
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
