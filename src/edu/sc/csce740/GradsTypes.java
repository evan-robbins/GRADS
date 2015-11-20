package edu.sc.csce740;

public enum GradsTypes {

	FAll("FALL"),
	SPRING("SPRING"),
	SUMMER("SUMMER");
	
	private final String string;
	
	private GradsTypes(String str)
	{
		this.string = str;
	}
	
	 public String toString() {
	       return this.string;
	    }
}
