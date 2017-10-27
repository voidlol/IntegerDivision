package integerDivision;

public class DivisionFormatter {
	
	String divider;
	String[] difference;
	String[] subtrahend;
	String dividend;
	String result;
	
	public DivisionFormatter(DivisionData divisionData) {
		this.divider = "" + divisionData.divider;
		this.result = divisionData.result;
		this.dividend = "" + divisionData.dividend;
		this.difference = new String[divisionData.difference.size()];
		this.subtrahend = new String[divisionData.subtrahend.size()];
		for (int i = 0; i < difference.length; i++) {
			this.difference[i] = Integer.toString(divisionData.difference.get(i));
		}
		for (int i = 0; i < subtrahend.length; i++) {
			this.subtrahend[i] = Integer.toString(divisionData.subtrahend.get(i));
		}
	}
	
	public String formatData() {
		StringBuilder output = new StringBuilder();
		output.append(" " + this.dividend + "|" + this.divider + "\n");
		output.append("-" + this.subtrahend[0]).append(addSpacesNTimes(dividend.length() - this.subtrahend[0].length()));
		output.append("|" + this.result + "\n");
		int spacesCount = 0;
		int iterator;
		for (iterator = 1; iterator < this.subtrahend.length; iterator++) {
			spacesCount += this.subtrahend[iterator - 1].length() - this.difference[iterator - 1].length() + 1;
			output.append(addSpacesNTimes(spacesCount + 1));
			output.append(this.difference[iterator - 1] + "\n");
			output.append(addSpacesNTimes(spacesCount + this.difference[iterator - 1].length() - this.subtrahend[iterator].length()));
			output.append("-" + this.subtrahend[iterator] + "\n");
		}
		spacesCount += this.subtrahend[iterator - 1].length() - this.difference[iterator - 1].length() + 1;
		output.append(addSpacesNTimes(spacesCount)).append(this.difference[iterator - 1]);
		return output.toString();
	}
	
	private String addSpacesNTimes(int n) {
		String output = "";
		for (int i = 0; i < n; i++) {
			output += " ";
		}
		return output;
	}
}
