 package Ca4006;

public class Robot {
	
	private Integer RobotID;
	private Integer Capacity;
	private Integer CurrentParts;

	public Robot(Integer id){
		this.RobotID = id;
		this.Capacity = 0;
		this.CurrentParts = 0;
	}

	public Integer GetRobotID(){
		return RobotID;
	}

	public Integer GetRobotCapacity(){
		return Capacity;
	}

	public Integer GetRobotCurrentParts(){
		return CurrentParts;
	}
}