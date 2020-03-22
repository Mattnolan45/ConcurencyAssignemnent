package Ca4006;

import java.util.*;  
import Ca4006.*;

public class InProductionList{
	private Queue<Aircraft> InProductionList;


	public InProductionList(){
		this.InProductionList = new LinkedList<Aircraft>();
	}

	public synchronized Aircraft RemoveFromProductionLine(){
		try { 
			wait();
		} catch (Exception e) {

		}
		
		return InProductionList.poll();
	}

	public synchronized void PutIntoProduction(Aircraft aircraft){
		try{
			InProductionList.add(aircraft);
			notify();
		} catch( Exception e){

		}	
	}

	public int size(){
		return InProductionList.size();
	}

}
