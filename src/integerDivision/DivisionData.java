package integerDivision;

import java.util.ArrayList;

public class DivisionData {
	String result = "";
	int divider;
	int dividend;
	ArrayList<Integer> subtrahend = new ArrayList<Integer>();
	ArrayList<Integer> difference = new ArrayList<Integer>();
	
	public DivisionData(int dividend, int divider) {
		this.dividend = dividend;
		this.divider = divider;
	}
	
	public void addResultDigit(int digit) {
		result += digit;
	}
	
	public void addSubtrahend(int subtrahend, int offset) {
		this.subtrahend.add((int) (subtrahend / Math.pow(10, offset)));
	}
	
	public void addDifference(int difference, int offset) {
		this.difference.add((int) (difference / Math.pow(10, offset)));
	}
}
