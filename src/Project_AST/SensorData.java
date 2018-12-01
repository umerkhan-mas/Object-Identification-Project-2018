package Project_AST;

import java.util.ArrayList;

public class SensorData {
	ArrayList<SensorDataItem> listOfSensorDataItem=new ArrayList<SensorDataItem>();
	
	public void Add_SensorDataItem(SensorDataItem sensorDataItem){
		listOfSensorDataItem.add(sensorDataItem);		
	}
	
	@Override
	public boolean equals(Object arg0) {
		SensorData other = (SensorData) arg0;
		
		if(this.listOfSensorDataItem.size() != other.listOfSensorDataItem.size())
			return false;
		
		for(int i=0; i<listOfSensorDataItem.size(); i++)
			if(this.listOfSensorDataItem.get(i) != other.listOfSensorDataItem.get(i))
				return false;
		
		return true;
		
		
	}
}
