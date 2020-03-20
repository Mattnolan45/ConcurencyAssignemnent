
import java.util.*;  

public class Aircraft{
	private Integer AircraftID;
	private Integer ArrivalTime;
	private List<String> WorkPlan;

	public Aircraft(Integer id, List<String> plan ){
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

	public List<String> getAricraftWorkPlan(){
		return WorkPlan;
	}
}