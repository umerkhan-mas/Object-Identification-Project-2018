package main.java;
import java.util.ArrayList;

public class Sensor {
	ArrayList<SensorData> listOfSensorData=new ArrayList<SensorData>();
	
	public void Add_SensorData(SensorData SensorData_){
		listOfSensorData.add(SensorData_);
	}
	
	public int size(){
		return this.listOfSensorData.size();		
	}
	
	public SensorData GetSensorDataAt(int index){
		return listOfSensorData.get(index);
	}
}

