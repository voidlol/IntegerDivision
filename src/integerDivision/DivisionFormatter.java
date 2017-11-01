package integerDivision;

import java.util.ArrayList;

public class DivisionFormatter {
	
	public String formatData(DivisionData divisionData) {
		if (divisionData == null) {
			return "Can't divide by zero";
		}
		String divider = null;
		String[] difference = null;
		String[] subtrahend = null;
		String dividend = null;
		String result = null;
		String period = null;
		String firstScale = null;
		period = divisionData.period;
		divider = "" + divisionData.divider;
		firstScale = "" + divisionData.firstScale;
		result = divisionData.result;
		dividend = "" + divisionData.dividend;
		difference = new String[divisionData.difference.size()];
		subtrahend = new String[divisionData.subtrahend.size()];
		for (int i = 0; i < difference.length; i++) {
			difference[i] = Integer.toString(divisionData.difference.get(i));
		}
		for (int i = 0; i < subtrahend.length; i++) {
			subtrahend[i] = Integer.toString(divisionData.subtrahend.get(i));
		}
		StringBuilder output = new StringBuilder();
		int spacesCount = firstScale.length() - subtrahend[0].length();
		output.append(" " + dividend + "|" + divider + "\n");
		output.append(multiplySpace(spacesCount));
		output.append("-" + subtrahend[0]).append(multiplySpace(dividend.length() - subtrahend[0].length() - spacesCount));
		period = findPeriod(period, divisionData.periodDifference);
		output.append("|" + result + period + "\n");
		int iterator;
		for (iterator = 1; iterator < subtrahend.length; iterator++) {
			spacesCount += subtrahend[iterator - 1].length() - difference[iterator - 1].length() + 1;
			output.append(multiplySpace(spacesCount + 1));
			output.append(difference[iterator - 1] + "\n");
			spacesCount += difference[iterator - 1].length() - subtrahend[iterator].length();
			output.append(multiplySpace(spacesCount));
			output.append("-" + subtrahend[iterator] + "\n");
		}
		spacesCount += subtrahend[iterator - 1].length() - difference[iterator - 1].length() + 1;
		output.append(multiplySpace(spacesCount)).append(difference[iterator - 1]);
		return output.toString();
	}
	
	private String findPeriod(String period, ArrayList<Integer> periodDifference) {
		if (period.equals("")) {
			return period;
		}
		int size = periodDifference.size();
		int index;
		int lastElement = periodDifference.get(size - 1);
		if (lastElement == 0) {
			period = "." + period;
		}
		else {
			for (index = 0; index < size - 1; index++) {
				if (lastElement == periodDifference.get(index)) {
					break;
				}
			}
			if (index != size - 1)
				period = "." + period.substring(0, index) + "(" + period.substring(index, period.length()) + ")"; 
			else
				period = "." + period;
		}
		
		return period;
	}
	
	private String multiplySpace(int amount) {
		String output = "";
		for (int i = 0; i < amount; i++) {
			output += " ";
		}
		return output;
	}
}
