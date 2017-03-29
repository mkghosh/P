package com.test;

import com.test.exp.MarksNotDefined;

public class Student {
	private String name;
	private String stId;
	private String department;
	private Marks marks;

	public Student(String name, String stId, String department) {
		super();
		this.name = name;
		this.stId = stId;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", stId=" + stId + ", department=" + department + ", marks=" + marks + "]";
	}

	public double getCumulativeGrade() throws MarksNotDefined {
		if(marks == null) {
			throw new MarksNotDefined("You have to define your marks first.");
		}
		double bngGrade = getGrade(marks.getBangla());
		double engGrade = getGrade(marks.getEnglish());
		double mathGrade = getGrade(marks.getMath());
		double scGrade = getGrade(marks.getScience());
		double soSCGrade = getGrade(marks.getSocialScience());
		return avg(bngGrade,engGrade,mathGrade,scGrade,soSCGrade);
	}

	private double avg(double bngGrade, double engGrade, double mathGrade, double scGrade, double soSCGrade) {
		// TODO Auto-generated method stub
		return (bngGrade + engGrade + mathGrade + scGrade + soSCGrade)/5;
	}

	/**
	 * @param mark
	 * @return
	 */
	private double getGrade(double mark) {
		int swVal = (int) Math.floor(mark / 10);
		double gradePoint = 0.0;
		switch (swVal) {
		case 4:
			gradePoint = 2.0;
			break;
		case 5:
			gradePoint = 3.0;
			break;
		case 6:
			gradePoint = 3.5;
			break;
		case 7:
			gradePoint = 4.0;
			break;
		case 8:
		case 9:
		case 10:
			gradePoint = 5.0;
			break;
		default:
			gradePoint = 0.0;
			break;
		}
		
		return gradePoint;
	}

}
