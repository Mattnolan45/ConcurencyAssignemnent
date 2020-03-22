package Ca4006;

import java.util.*;  
import Ca4006.*;

public class InProductionList{
	private Queue<Aircraft> InProductionList;


	public InProductionList(){
		this.InProductionList = new LinkedList<Aircraft>();
	}

	public synchronized Aircraft WaitForProductionLine(){ // robot controller consumer
		try { 
			wait();

		} catch (Exception e) {

		}
		return CheckForOpenAircraft();
	}

	public synchronized void PutIntoProductionList(Aircraft aircraft){ // producer
		try{
			InProductionList.add(aircraft);
			notify();
		} catch( Exception e){

		}	
	}


	public void RemoveFromProductionList(int aircraftid){
		InProductionList.poll();
		System.out.println("Removing Aircraft: " + aircraftid + " from Production Line");
		System.out.println();

	}


	public Aircraft CheckForOpenAircraft(){
		for(Aircraft a : InProductionList){
			if(a.getWorkedOn() == false){
				a.UpdateWorkedOn();
				return a;
			}
		}
		return null ;
	}


	public int size(){
		return InProductionList.size();
	}

}
