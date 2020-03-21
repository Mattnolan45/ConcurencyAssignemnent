package Ca4006;


import java.util.Arrays;
import java.util.logging.Logger;

public class Robot implements Runnable {
	
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