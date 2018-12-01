package Project_AST;

import static org.junit.Assert.*;

import org.junit.Test;

public class SensorTest {
	@Test
	public void GetDataForTest() {
		
	SensorDataItem object1= new SensorDataItem();
	object1.Get_SensorDataItem("knife",1,99.);
	SensorDataItem object2= new SensorDataItem();
	object2.Get_SensorDataItem("scissor",2,65.);
	SensorDataItem object3= new SensorDataItem();
	object3.Get_SensorDataItem("spoon",3,33.);
	SensorDataItem object4= new SensorDataItem();
	object4.Get_SensorDataItem("spoon",4,80.);
	SensorDataItem object5= new SensorDataItem();
	object5.Get_SensorDataItem("keys",5,95.);
	
	SensorDataItem object6= new SensorDataItem();
	object6.Get_SensorDataItem("knife",1,55.);
	SensorDataItem object7= new SensorDataItem();
	object7.Get_SensorDataItem("scissor",2,95.);
	SensorDataItem object8= new SensorDataItem();
	object8.Get_SensorDataItem("fork",3,99.);
	SensorDataItem object9= new SensorDataItem();
	object9.Get_SensorDataItem("spoon",4,99.);
	SensorDataItem object10= new SensorDataItem();
	object10.Get_SensorDataItem("keys",5,95.);
	
	
	SensorData obj1= new SensorData();
	obj1.Get_SensorData(object1);
	obj1.Get_SensorData(object2);
	obj1.Get_SensorData(object3);
	obj1.Get_SensorData(object4);
	obj1.Get_SensorData(object5);
	
	SensorData obj2= new SensorData();
	obj2.Get_SensorData(object6);
	obj2.Get_SensorData(object7);
	obj2.Get_SensorData(object8);
	obj2.Get_SensorData(object9);
	obj2.Get_SensorData(object10);
	
		
	Sensor sensor1= new Sensor();
	sensor1.Get_Sensor(obj1);
	sensor1.Get_Sensor(obj2);
	
	
	ObjectClassifier classi=new ObjectClassifier();
	classi.Classify(sensor1);
		

	}
}
