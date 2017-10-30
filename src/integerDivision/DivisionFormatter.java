package integerDivision;

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
		String firstDigit = null;
		divider = "" + divisionData.divider;
		firstDigit = "" + divisionData.firstDigit;
		result = divisionData.result;
		dividend = "" + divisionData.dividend;
		difference = new String[divisionData.difference.size()];
		subtrahend = new String[divisionData.subtrahend.size()];
		for (int i = 0; i < difference.length; i++) {
			difference[i] = Integer.toString(Math.abs(divisionData.difference.get(i)));
		}
		for (int i = 0; i < subtrahend.length; i++) {
			subtrahend[i] = Integer.toString(Math.abs(divisionData.subtrahend.get(i)));
		}
		StringBuilder output = new StringBuilder();
		int spacesCount = firstDigit.length() - subtrahend[0].length();
		output.append(" " + dividend + "|" + divider + "\n");
		output.append(getStringWithNSpaces(spacesCount));
		output.append("-" + subtrahend[0]).append(getStringWithNSpaces(dividend.length() - subtrahend[0].length() - spacesCount));
		if (divider.startsWith("-")) {
			output.append("|-" + result + "\n");
		}
		else {
			output.append("|" + result + "\n");
		}
		int iterator;
		for (iterator = 1; iterator < subtrahend.length; iterator++) {
			spacesCount += subtrahend[iterator - 1].length() - difference[iterator - 1].length() + 1;
			output.append(getStringWithNSpaces(spacesCount + 1));
			output.append(difference[iterator - 1] + "\n");
			output.append(getStringWithNSpaces(spacesCount + difference[iterator - 1].length() - subtrahend[iterator].length()));
			output.append("-" + subtrahend[iterator] + "\n");
		}
		spacesCount = dividend.length() - difference[iterator - 1].length() + 1;
		output.append(getStringWithNSpaces(spacesCount)).append(difference[iterator - 1]);
		return output.toString();
	}
	
	private String getStringWithNSpaces(int n) {
		String output = "";
		for (int i = 0; i < n; i++) {
			output += " ";
		}
		return output;
	}
}
