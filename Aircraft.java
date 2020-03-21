package Ca4006;

import java.util.*;
import java.util.Random;   
import Ca4006.Part;

public class Aircraft implements Runnable {
	private Integer AircraftID;
	private Integer ArrivalTime;
	private Queue<Part> WorkPlan;
	private boolean ReadyForProduction;

	public Aircraft(Integer id){
		this.AircraftID = id; 
		this.ArrivalTime = 0; //  not sure if needed
		this.WorkPlan = GenerateWorkPlan();
		this.ReadyForProduction = false;
	}

	public Integer getAircraftId(){
		return AircraftID;
	}

	public Integer getAircraftArrivalTime(){
		return ArrivalTime;
	}

	public Queue<Part> getAricraftWorkPlan(){
		return WorkPlan;
	}

	public Queue<Part> GenerateWorkPlan(){
		Random rand = new Random();
		Queue<Part> workplan = new LinkedList<Part>();
		
		for(int i = 0; i <= rand.nextInt(5); i++ ){ // adds random amount of parts
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