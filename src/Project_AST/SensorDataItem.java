package Project_AST;

public class SensorDataItem {
	int ObjectCount;
	Double Probability;
	String ObjectName;
	public void Get_SensorDataItem(String Name,int Count,Double Prob){
		this.ObjectCount=Count;
		this.Probability=Prob;
		this.ObjectName=Name;
		System.out.println(this.ObjectName);
		
	}
		
}
