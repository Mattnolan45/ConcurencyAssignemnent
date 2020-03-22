package Ca4006;

import java.util.*;
import java.util.Random;   
import Ca4006.Part;

public class Aircraft {
	private Integer AircraftID;
	private Integer ArrivalTime;
	private List<Part> WorkPlan;
	private boolean WorkedOn;

	public Aircraft(Integer id){
		this.AircraftID = id; 
		this.ArrivalTime = 0; //  not sure if needed
		this.WorkPlan = GenerateWorkPlan();
		this.WorkedOn = false;
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

	public boolean getWorkedOn(){
		return WorkedOn;
	}

	public void UpdateWorkedOn(){
		if(WorkedOn == false){
			WorkedOn = true;
		}
		else{
			WorkedOn = false;
		}
	}

	public List<Part> GenerateWorkPlan(){
		Random rand = new Random();
		List<Part> workplan = new ArrayList<Part>();
		
		for(int i = 0; i <= rand.nextInt((5-1)+1); i++ ){ // adds random amount of parts > 0 parts
			Part newPart = new Part(rand.nextInt(3)); // picks random part
			workplan.add(newPart);
		}
		return workplan;
	}

	public void print(){
		System.out.println("AircraftID: " + AircraftID);
	}

}