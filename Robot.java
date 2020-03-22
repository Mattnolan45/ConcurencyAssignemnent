package Ca4006;

import Ca4006.*;
import java.util.*;


public class Robot implements Runnable {
	
	private Integer RobotID;
	private Queue<Part> CurrentWorkPlan;

	public Robot(Integer id, Queue<Part> part ){
		this.RobotID = id;
		this.CurrentWorkPlan = new LinkedList<Part>();
	}

	public Integer GetRobotID(){
		return RobotID;
	}

	
	public Queue<Part> GetRobotCurrentParts(){
		return CurrentWorkPlan;
	}

	public void print_info()
	{
		System.out.println("Robot" + GetRobotID() + "in Thread" + Thread.currentThread().getName() + " is working on Aircraft CHANGE TO PUT DYNAMIC NUMBER HERE and will take AMOUNT OF TIME HERE");
	}

	public synchronized void do_install() throws InterruptedException
	{
	
	}

	@Override
	public void run()
	{
		print_info();

		try
		{
			do_install();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}