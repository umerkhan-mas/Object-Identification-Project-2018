package main.java;

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
			if(!this.listOfSensorDataItem.get(i).equals(other.listOfSensorDataItem.get(i)))
				return false;
		
		return true;
		
		
	}
	
	public int size(){
		return this.listOfSensorDataItem.size();		
	}
	
	public SensorDataItem GetSensorDataItemAt(int index){
		return listOfSensorDataItem.get(index);
	}
	
	public boolean ContainsId(int objectId){
		for(int i=0; i<size(); i++){
			if(GetSensorDataItemAt(i).GetId() == objectId)
				return true;
		}
		return false;
	}
	
	public SensorDataItem GetSensorDataItemWithId(int id){
		for(int i=0; i<size(); i++){
			if(GetSensorDataItemAt(i).GetId() == id)
				return GetSensorDataItemAt(i);
		}
		return null;
	}
	
}
