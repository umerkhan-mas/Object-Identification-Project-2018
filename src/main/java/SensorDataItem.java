package main.java;

public class SensorDataItem {
	int ObjectId;
	Double Probability;
	String ObjectName;

	public SensorDataItem() {
		
	}
	public SensorDataItem(String Name,int Id,Double Prob) throws Exception {
		Set_SensorDataItem(Name, Id, Prob);
	}
	
	public void Set_SensorDataItem(String Name,int Id,Double Prob) throws Exception{
		this.SetName(Name);
		this.SetProbability(Prob);
		this.SetId(Id);
	}
	
	public void SetName(String Name){
		this.ObjectName = Name;
	}
	
	public String GetName(){
		return this.ObjectName;
	}
	
	public void SetId(int Id){
		this.ObjectId = Id;
	}
	
	public int GetId(){
		return this.ObjectId;
	}
	
	public void SetProbability(Double Probability) throws Exception{
		if(Probability > 100 || Probability < 0)
			throw new Exception("Invalid Probability provided : " + Probability);		
		this.Probability = Probability;
	}
	
	public Double GetProbability(){
		return this.Probability;
	}
	
	@Override
	public boolean equals(Object arg0) {
		SensorDataItem other = (SensorDataItem) arg0;

		if(this.GetId() != other.GetId())
			return false;
		if(!this.GetName().equals(other.GetName()))
			return false;
		if(!this.GetProbability().equals(other.GetProbability()))
			return false;
		
		return true;
	}
		
}
