package com.test.exp;

public class MarksNotDefined extends Exception {
	public MarksNotDefined() {
		super("Marks has not been set yet");
	}
	
	public MarksNotDefined(String msg) {
		super(msg);
	}
}
