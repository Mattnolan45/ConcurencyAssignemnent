package Ca4006;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;  
import Ca4006.*;

public class RobotController implements Runnable{
	private Queue<Robot> waitingRobots;
	private InProductionList InProduction;


	public RobotController(InProductionList inProductionList){
		this.waitingRobots = new LinkedList<Robot>();
		this.InProduction = inProductionList;
	}

	public void GenerateRobots(){
		Queue<Part> partsToBeInstalled = new LinkedList<Part>();  

		for(int i = 0; i < 5; i++){
			Robot newRobot = new Robot(i,partsToBeInstalled);
			waitingRobots.add(newRobot);
		}

	}

	public void assignRobotJob(Robot robot, Aircraft aircraft){

	}

	@Override
	public void run(){
		GenerateRobots();
		System.out.println("waitingRobots: " + waitingRobots.size());
		System.out.println();

		System.out.println("Thread Pool Started");
		ExecutorService pool = Executors.newFixedThreadPool(3); // starts thread pool
		System.out.println();

		while(true){
			InProduction.WaitForProductionLine();
			if(InProduction.size() > 1){
				Aircraft openAircraft = InProduction.CheckForOpenAircraft();
				if(openAircraft != null){
					Robot currentRobot = waitingRobots.poll();
					System.out.println("Ready To start robot: " + currentRobot.GetRobotID() );
					System.out.println();
					// assign to robot
					//
				}
			}
		}

	}

}