package Project_AST;

import java.util.ArrayList;

public class SensorData {
	ArrayList<Object> listOfSensorDataItem=new ArrayList<Object>();
	public void Get_SensorData(SensorDataItem objects){
		listOfSensorDataItem.add(objects);
		System.out.println(listOfSensorDataItem.get(0));
		
	}
}
