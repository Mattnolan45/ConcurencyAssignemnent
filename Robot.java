package Ca4006;

import Ca4006.*;
import java.util.*;


public class Robot implements Runnable {
	
	private Integer RobotID;
	private Integer AircraftID;
	private List<Part> CurrentWorkPlan;

	public Robot(Integer id, List<Part> part ){
		this.RobotID = id;
		this.CurrentWorkPlan = new ArrayList<Part>();
		this.AircraftID = null;
	}

	public Integer GetRobotID(){
		return RobotID;
	}

	
	public List<Part> GetRobotCurrentWorkPlan(){
		return CurrentWorkPlan;
	}

	public void SetRobotCurrentWorkPlan(List<Part> parts){
		CurrentWorkPlan = parts;
	}

	public void print_info()
	{
		System.out.println("Robot: " + RobotID + " is working on Aircraft: "+ AircraftID);
	}

	public void robotSleep(int time){
		try{
			Thread.sleep(time*1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void doInstall(){

		if (CurrentWorkPlan.size() > 0) {
			for(Part p : CurrentWorkPlan){
				System.out.println("Robot: " + RobotID + " is installing part: " + p.GetPartID() + " on Aircraft: " + AircraftID);
				robotSleep(p.GetPartInstallTime());
			}	
		}else{
			System.out.println("CurrentWorkPlan is empty");

		}

	}

	@Override
	public void run()
	{
		print_info();
		doInstall();
	}
}