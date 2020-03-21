package Ca4006;

import java.util.*;
import java.util.Random;   
import Ca4006.Part;

public class Aircraft implements Runnable {
	private Integer AircraftID;
	private Integer ArrivalTime;
	private List<Part> WorkPlan;

	public Aircraft(Integer id){
		this.AircraftID = id; 
		this.ArrivalTime = 0;
		this.WorkPlan = GenerateWorkPlan();
		
	}

	public Integer getAircraftId(){
		return AircraftID;
	}

	public Integer getAircraftArrivalTime(){
		return ArrivalTime;
	}

	public List<Part> getAricraftWorkPlan(){
		return WorkPlan;
	}

	public List<Part> GenerateWorkPlan(){
		Random rand = new Random();
		List<Part> workplan = new ArrayList<Part>();
		
		for(int i = 0; i <= rand.nextInt(5); i++ ){
			Part newPart = new Part(rand.nextInt(3)); // picks random part
			workplan.add(newPart);
		}
		return workplan;

	}

	public void print(){
		System.out.println("ID: " + AircraftID + " WorkPlan: " + WorkPlan);
	}

	@Override
	public void run(){
		System.out.println("Aircraft: " + AircraftID);
		this.print();
	}
}