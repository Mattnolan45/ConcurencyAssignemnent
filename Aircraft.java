package Ca4006;

import java.util.*;  
import Ca4006.Part;

public class Aircraft{
	private Integer AircraftID;
	private Integer ArrivalTime;
	private List<Part> WorkPlan;

	public Aircraft(Integer id, List<Part> plan ){
		this.AircraftID = id; 
		this.ArrivalTime = 0;
		this.WorkPlan = plan;
		
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
}