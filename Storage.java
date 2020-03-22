package Ca4006;

import java.util.*;  
import Ca4006.Part;

public class Storage{
	private List<Part> StorageList;

	public Storage(){
		this.StorageList = GenerateStorageList();
	}

	public List<Part> GenerateStorageList(){
		List<Part> storageList = new ArrayList<Part>();
		
		for(int i = 0; i <= 3; i++ )
		{
			for(int j = 0;j<=2; j++)
			{
				Part newPart = new Part(i);
				storageList.add(newPart);
			}
		}
		return storageList;
	}

	public List<Part> GetStorageList(){
		return StorageList;
	}

	public void print_storage()
	{
		for(int i = 0; i < StorageList.size(); i++)
		{
			System.out.println(StorageList.get(i).GetPartID());
		}
	}

	public synchronized boolean CheckParts(List<Part> aircraftWorkPlan){

		for(Part p : aircraftWorkPlan){
			
			for(Part storedPart : StorageList){
				
				if(storedPart.GetPartID() == p.GetPartID()){
					try{
						int index = FindIndexInStorage(StorageList, storedPart);
						StorageList.remove(StorageList.get(index));	
						
					}catch(Exception e){
						return false;
					}
					
				}
				else{
					return false; // not all parts found
				}
			}
		}
		System.out.println("prnt true");
		return true; // all parts found
	}

	public synchronized void AddToStorageList(){
		
	}




	public int FindIndexInStorage(List<Part> parts, Part part){
		if(parts != null){
			int i = 0;
			while(i < parts.size()){
				System.out.println(parts.get(i).GetPartID());
				if(parts.get(i).GetPartID() == part.GetPartID()){
	
					return i;
				}
				else{
					i++;
				}
			}
		}
		return -1;
	}
}