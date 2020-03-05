package main.java;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectClassifier implements IClassify {
	
	public SensorData Classify(Sensor sensors){
		ArrayList<Integer> UniqueList= UniqueData(sensors);
		SensorData resultantData = new SensorData();		
		
		Collections.sort(UniqueList);
		for(int ObjectId=0; ObjectId<UniqueList.size(); ObjectId++){
			SensorDataItem dataItem = null;
			
			for(int SensorNumber=0; SensorNumber<sensors.size(); SensorNumber++){
				SensorData sensorData = sensors.GetSensorDataAt(SensorNumber);
				SensorDataItem temp = sensorData.GetSensorDataItemWithId(UniqueList.get(ObjectId));
				if(temp == null)
					continue;
				else if (dataItem == null){
					dataItem = temp;
				}
				else{
					if(temp.GetProbability() > dataItem.GetProbability())
						dataItem = temp;
				}					
			}
			resultantData.Add_SensorDataItem(dataItem);
		}
		
		return resultantData;
	}
		
	public ArrayList<Integer> UniqueData(Sensor sensors){
		ArrayList<Integer> UniqueIds= new ArrayList<Integer>();
		for(int i=0;i<sensors.size();i++)
		{
			SensorData sensorData = sensors.GetSensorDataAt(i);
			int length_of_sensordata = sensorData.size();
			for(int j=0;j<length_of_sensordata;j++)
			{
				SensorDataItem sensorDataItem = sensorData.GetSensorDataItemAt(j);
				int ObjectId = sensorDataItem.GetId();
				if (!UniqueIds.contains(ObjectId))
				{
					UniqueIds.add(ObjectId);
				}
			}
			
		}
		return UniqueIds;
	}

}
