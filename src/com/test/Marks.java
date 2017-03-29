package com.test;

public class Marks {
	private double bangla;
	private double english;
	private double math;
	private double science;
	private double socialScience;
	
	public Marks(double bangla, double english, double math, double science, double socialScience) {
		super();
		this.bangla = bangla;
		this.english = english;
		this.math = math;
		this.science = science;
		this.socialScience = socialScience;
	}
	
	public double getBangla() {
		return bangla;
	}
	public void setBangla(double bangla) {
		this.bangla = bangla;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getScience() {
		return science;
	}
	public void setScience(double science) {
		this.science = science;
	}
	public double getSocialScience() {
		return socialScience;
	}
	public void setSocialScience(double socialScience) {
		this.socialScience = socialScience;
	}	
	
	@Override
	public String toString() {
		return "Marks [bangla=" + bangla + ", english=" + english + ", math=" + math + ", science=" + science
				+ ", socialScience=" + socialScience + "]";
	}
}
