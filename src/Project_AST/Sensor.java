package Project_AST;
import java.util.ArrayList;

public class Sensor {
	ArrayList<SensorData> listOfSensorData=new ArrayList<SensorData>();
	
	public void Add_SensorData(SensorData SensorData_){
		listOfSensorData.add(SensorData_);
	}
	public int getSensorDataSize(){
		return this.listOfSensorData.size();
		
	}
}

