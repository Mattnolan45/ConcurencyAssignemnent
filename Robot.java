package Ca4006;

import Ca4006.*;
import java.util.*;


public class Robot implements Runnable {
	
	private Integer RobotID;
	private Integer AircraftID;
	private List<Part> CurrentWorkPlan;
	private InProductionList InProduction;

	public Robot(Integer id, List<Part> part, InProductionList inProduction ){
		this.RobotID = id;
		this.CurrentWorkPlan = new ArrayList<Part>();
		this.AircraftID = null;
		this.InProduction = inProduction;
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
		System.out.println();
	}

	public void robotSleep(int time){ // carry out work
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
				System.out.println();
				
				robotSleep(p.GetPartInstallTime());
				
				System.out.println("Robot: " + RobotID + " Finished installing part: " + p.GetPartID() + " on Aircraft: " + AircraftID);
				System.out.println();
			}	
			
			System.out.println("Robot: " + RobotID + " has completed its work on Aircraft: " + AircraftID);
			System.out.println();

			InProduction.RemoveFromProductionList(AircraftID);

		}else{
			System.out.println("CurrentWorkPlan is empty");
			System.out.println();

		}

	}



	public void SetAircraftID(int AirID)
	{
		AircraftID = AirID;
	}

	@Override
	public void run()
	{
		print_info();
		doInstall();

		// remove from production line
	}
}