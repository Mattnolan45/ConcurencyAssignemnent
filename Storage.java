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
}