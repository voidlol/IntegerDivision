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
		String firstScale = null;
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
		output.append("|" + result + "\n");
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
	
	private String multiplySpace(int amount) {
		String output = "";
		for (int i = 0; i < amount; i++) {
			output += " ";
		}
		return output;
	}
}
