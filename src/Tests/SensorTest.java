package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Project_AST.ObjectClassifier;
import Project_AST.Sensor;
import Project_AST.SensorData;
import Project_AST.SensorDataItem;

public class SensorTest {
	@Test
	public void GetDataForTest() throws Exception {
		
	// Arrange
	SensorData sensorData1 = new SensorData();
	SensorData sensorData2 = new SensorData();
	Sensor sensors = new Sensor();

	sensorData1.Add_SensorDataItem(new SensorDataItem("knife",1,99.));
	sensorData1.Add_SensorDataItem(new SensorDataItem("scissor",2,65.));
	sensorData1.Add_SensorDataItem(new SensorDataItem("spoon",3,33.));
	sensorData1.Add_SensorDataItem(new SensorDataItem("spoon",4,80.));
	sensorData1.Add_SensorDataItem(new SensorDataItem("keys",5,95.));

	sensorData2.Add_SensorDataItem(new SensorDataItem("knife",1,55.));
	sensorData2.Add_SensorDataItem(new SensorDataItem("scissor",2,95.));
	sensorData2.Add_SensorDataItem(new SensorDataItem("fork",3,99.));
	sensorData2.Add_SensorDataItem(new SensorDataItem("spoon",4,99.));
	sensorData2.Add_SensorDataItem(new SensorDataItem("keys",5,95.));

	sensors.Add_SensorData(sensorData1);
	sensors.Add_SensorData(sensorData2);
	
	SensorData ExpectedResult = new SensorData();
	ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife",1,99.));
	ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor",2,95.));
	ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork",3,99.));
	ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon",4,99.));
	ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys",5,95.));
	
	SensorData ActualResult = null;
	
	// Act
	
	ObjectClassifier classier = new ObjectClassifier();
	ActualResult = classier.Classify(sensors);
	
	// Assert
	assertEquals(ExpectedResult, ActualResult);
		

	}
}
