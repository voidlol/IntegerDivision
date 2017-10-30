package integerDivision;

import java.util.ArrayList;

public class DivisionData {
	String result = "";
	int divider;
	int dividend;
	int firstScale;
	ArrayList<Integer> subtrahend = new ArrayList<Integer>();
	ArrayList<Integer> difference = new ArrayList<Integer>();
	private static final int NUMERAL_SYSTEM = 10;
	
	public DivisionData(int dividend, int divider) {
		this.dividend = dividend;
		this.divider = divider;
	}
	
	public void setFirstScale(int firstScale, int offset) {
		this.firstScale = firstScale / calculateScale(offset);
	}
	
	public void addResultDigit(int digit) {
		result += digit;
	}
	
	public void addSubtrahend(int subtrahend, int offset) {
		this.subtrahend.add(subtrahend / calculateScale(offset));
	}
	
	public void addDifference(int difference, int offset) {
		this.difference.add(difference / calculateScale(offset));
	}
	
	private int calculateScale(int offset) {
		return (int) Math.pow(NUMERAL_SYSTEM, offset);
	}
}
