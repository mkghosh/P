package com.test;

public class Result {
	
	private String stID;
	private String stName;
	private double cgpa;
	private String grade;
	
	public Result(String stID, String stName, double cgpa) {
		super();
		this.stID = stID;
		this.stName = stName;
		this.cgpa = cgpa;
		this.grade = calcGrade(cgpa);
	}
	private String calcGrade(double cgpa) {
		String grade = "F";
		if(cgpa == 5) 
			grade = "A+";
		else if(cgpa <5 && cgpa >= 4) 
			grade = "A";
		else if(cgpa < 4 && cgpa >= 3.5) 
			grade = "A-";
		else if(cgpa < 3.5 && cgpa >= 3) 
			grade = "B";
		else if(cgpa < 3 && cgpa >= 2)
			grade = "C";
		else if(cgpa < 2 && cgpa >= 1)
			grade = "D";
		return grade;
	}
	
	public String getStID() {
		return stID;
	}
	public String getStName() {
		return stName;
	}
	public double getCgpa() {
		return cgpa;
	}
	public String getGrade() {
		return grade;
	}
	
	
	
}
