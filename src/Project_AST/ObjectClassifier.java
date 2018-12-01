package Project_AST;
import java.util.ArrayList;

public class ObjectClassifier {
	
	public SensorData Classify(Sensor sensors){
		ArrayList<String> UniqueList=null;
		UniqueList=UniqueData(sensors);
		return null;
	}
		
	public ArrayList UniqueData(Sensor sensors){	
		String Name;
		int Id;
		Double Probability;
		ArrayList<String> UniqueName=null;
		for(int i=0;i<sensors.listOfSensorData.size();i++)
		{
			SensorData x=sensors.listOfSensorData.get(i);
			System.out.println("Hello");
			int length_of_sensordata=x.getSensorDataItemSize();
			for(int j=0;j<length_of_sensordata;j++)
			{
				System.out.println("checkpoint2");
				SensorDataItem y=x.listOfSensorDataItem.get(j);
				System.out.println(y);
				Name=y.GetName();
				System.out.println(Name);
				if (UniqueName.contains(Name))
				{
					System.out.println("Name");
				}
				else
				{
					UniqueName.add(Name);
					System.out.println("Name");
				}
				
				
			System.out.println(Name);
			}
			
		}
		for(int i=0;i<UniqueName.size();i++){
			System.out.println(UniqueName.get(i));
		}
		return null;
		}

}
