package integerDivision;

import java.util.ArrayList;

public class DivisionData {
	String result = "";
	int divider;
	int dividend;
	int firstDigit;
	ArrayList<Integer> subtrahend = new ArrayList<Integer>();
	ArrayList<Integer> difference = new ArrayList<Integer>();
	private static final int NUMERAL_SYSTEM = 10;
	
	public DivisionData(int dividend, int divider) {
		this.dividend = dividend;
		this.divider = divider;
	}
	
	public void setFirstDigit(int firstDigit, int offset) {
		this.firstDigit = firstDigit / getDigit(offset);
	}
	
	public void addResultDigit(int digit) {
		result += digit;
	}
	
	public void addSubtrahend(int subtrahend, int offset) {
		this.subtrahend.add(subtrahend / getDigit(offset));
	}
	
	public void addDifference(int difference, int offset) {
		this.difference.add(difference / getDigit(offset));
	}
	
	private int getDigit(int offset) {
		return (int) Math.pow(NUMERAL_SYSTEM, offset);
	}
}
