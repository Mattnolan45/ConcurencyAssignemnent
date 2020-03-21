package Ca4006;	

public class Part{

	private int PartID;
	private int InstallTime;

	public Part(int id){
		this.PartID = id;
		if(id == 0){
			this.InstallTime = 5;
		}
		else if (id == 1) {
			this.InstallTime = 4;	
		}
		else if (id == 2) {
			this.InstallTime = 3;
		}
		else if (id == 3) {
			this.InstallTime = 2;
		}		
	}

	public int GetPartID(){
		return PartID;
	}

	public int GetPartInstallTime(){
		return InstallTime;
	}



}