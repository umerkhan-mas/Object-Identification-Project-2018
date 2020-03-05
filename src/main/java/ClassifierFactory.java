package main.java;

public class ClassifierFactory {
public ObjectClassifier getClassifier(String Classifiertype){
	if(Classifiertype==null){
		return null;
	}
	if(Classifiertype=="ObjectClassifier"){
		return new ObjectClassifier();
	}
	
	return null;
}
}
