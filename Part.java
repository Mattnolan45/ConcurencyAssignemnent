package Ca4006;	

public class Part{
	
	private int PartID;
	private int InstallTime;

	public Part(int id, int time){
		this.PartID = id;
		this.InstallTime = time;
	}

	public int GetPartID(){
		return PartID;
	}

	public int GetPartInstallTime(){
		return InstallTime;
	}

}