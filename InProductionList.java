package Ca4006;

import java.util.*;  
import Ca4006.*;

public class InProductionList{
	private Queue<Aircraft> InProductionList;


	public InProductionList(){
		this.InProductionList = new LinkedList<Aircraft>();
	}

	public synchronized void WaitForProductionLine(){
		try { 
			wait();
		} catch (Exception e) {

		}
	}

	public synchronized void PutIntoProductionList(Aircraft aircraft){
		try{
			InProductionList.add(aircraft);
			notify();
		} catch( Exception e){

		}	
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
