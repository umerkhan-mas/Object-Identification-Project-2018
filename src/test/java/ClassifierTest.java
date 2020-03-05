package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.ClassifierFactory;
import main.java.IClassify;
import main.java.Sensor;
import main.java.SensorData;
import main.java.SensorDataItem;

public class ClassifierTest {
	
	final String CLASSIFIERTYPE= "ObjectClassifier";

	@Test
	public void ClassifierTestBasic() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("scissor", 2, 95.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);

		SensorData ExpectedResult = new SensorData();
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 95.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);
		

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestForSingleExclusive() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);

		SensorData ExpectedResult = new SensorData();
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestForMultipleExclusive() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);

		SensorData ExpectedResult = new SensorData();
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestForUnion() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));

		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);

		SensorData ExpectedResult = new SensorData();
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestForSingleSensor() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);

		SensorData ExpectedResult = sensorData1;

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestWithEmptySensorData() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		SensorData sensorData3 = new SensorData();
		Sensor sensors = new Sensor();

		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		sensors.Add_SensorData(sensorData3);

		SensorData ExpectedResult = new SensorData();
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}

	@Test
	public void ClassifierTestWithEmptySensor() throws Exception {

		// Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		SensorData sensorData3 = new SensorData();
		Sensor sensors = new Sensor();


		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		sensors.Add_SensorData(sensorData3);

		SensorData ExpectedResult = new SensorData();

		SensorData ActualResult = null;

		// Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		// Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test
	public void ClassifierTestwithAlgorithmData_Conventionalcase() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		SensorData sensorData3 = new SensorData();
		SensorData sensorData4 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 89.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 35.));
		sensorData3.Add_SensorDataItem(new SensorDataItem("knife", 1, 69.));
		sensorData4.Add_SensorDataItem(new SensorDataItem("knife", 1, 80.));
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		sensors.Add_SensorData(sensorData3);
		sensors.Add_SensorData(sensorData4);

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 89.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test
	public void ClassifierTestwithAlgorithmData_EmptySensorData() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		SensorData sensorData3 = new SensorData();
		SensorData sensorData4 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		sensors.Add_SensorData(sensorData3);
		sensors.Add_SensorData(sensorData4);

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
		
		
	}
	
	@Test
	public void ClassifierTestwithAlgorithmData_Single() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 89.));
		
		
		sensors.Add_SensorData(sensorData1);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 89.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
		
	@Test
	public void ClassifierTestwith_Case1() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 4, 80.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));
		
		sensorData2.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("scissor", 2, 95.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 55.));
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 95.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("keys", 5, 95.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test
	public void ClassifierTestwith_Case2() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test
	public void ClassifierTestwith_Case3() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test
	public void ClassifierTestwith_Case4() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		
		
		sensorData2.Add_SensorDataItem(new SensorDataItem("KNIFE", 1, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("SCISSOR", 2, 65.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("SPOON", 3, 33.));
		
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 3, 33.));
		
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);
		System.out.println(ActualResult);
		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	
	@Test
	public void ClassifierTestwith_Case5() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		
		
		
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("scissor", 2, 65.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("spoon", 4, 99.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
	
	@Test
	public void ClassifierTestwith_Case6() throws Exception{
		//Arrange
		SensorData sensorData1 = new SensorData();
		SensorData sensorData2 = new SensorData();
		
		Sensor sensors = new Sensor();
		
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 94.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 69.));
		sensorData1.Add_SensorDataItem(new SensorDataItem("knife", 1, 89.));
		
		sensorData2.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		sensorData2.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		
		sensors.Add_SensorData(sensorData1);
		sensors.Add_SensorData(sensorData2);
		

		SensorData ActualResult = null;
		SensorData ExpectedResult =new SensorData() ;
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("knife", 1, 99.));
		ExpectedResult.Add_SensorDataItem(new SensorDataItem("fork", 3, 99.));
		
		//Act
		ClassifierFactory classifierFactory= new ClassifierFactory();
		IClassify classifier= classifierFactory.getClassifier(CLASSIFIERTYPE);
		ActualResult = classifier.Classify(sensors);

		//Assert
		assertEquals(ExpectedResult, ActualResult);
	}
	
}
