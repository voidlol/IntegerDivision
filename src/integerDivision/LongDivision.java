package integerDivision;

public class LongDivision {
	
	public String divide(int dividend, int divider) {
		StringBuilder output = new StringBuilder();
		if (divider == 0) {
			return "Can't divide by ZERO!";
		}
		if (divider > dividend) {
			return "Only integer division is supported.";
		}
		int dividendLength = (int) (Math.log10(dividend) + 1);
		int dividerLength = (int) (Math.log10(divider) + 1);
		int result = dividend / divider;
		if (divider < 0) {
			divider = -divider;
		}
		output.append(" ").append(dividend).append("|").append(divider).append("\n");
		int currentPow = dividendLength - dividerLength;
		int startDigit = (int) (dividend / Math.pow(10, currentPow));
		int currentDigit = 0;
		int difference = 0;
		int multiply;
		if (startDigit < divider) {
			currentPow--;
			startDigit = (int) (dividend / Math.pow(10, currentPow));
		}
		multiply = startDigit / divider * divider;
		difference = startDigit - multiply;
		printSpacesNTimes(calculateOffset(startDigit, multiply) - 1, output);
		output.append("-").append(multiply);
		printSpacesNTimes(dividendLength  - 1 - (int)Math.log10(startDigit), output);
		output.append("|").append(result).append("\n");
		
		while (currentPow > 0 ) {
			currentPow--;
			currentDigit = (int)(dividend / Math.pow(10, currentPow));
			startDigit = difference * 10 + currentDigit % 10; 
			if (startDigit >= divider) {
				printSpacesNTimes(calculateOffset(currentDigit, difference), output);
				output.append(startDigit).append("\n");
				multiply = startDigit / divider * divider;
				printSpacesNTimes(calculateOffset(currentDigit, multiply), output);
				output.append("-").append(multiply).append("\n");
				difference = startDigit - multiply;
			}
			else {
				difference = startDigit;
			}
		}
		if (difference != 0) {
			printSpacesNTimes(1, output);
		}
		printSpacesNTimes(calculateOffset(dividend, difference), output);
		output.append(difference).append("\n");
		return output.toString();
	}
	
	private void printSpacesNTimes(int n, StringBuilder print) {
		for (int i = 0; i < n; i++) {
			print.append(" ");
		}
	}
	
	private int calculateOffset(int biggerNumber, int smallerNumber) {
		if (smallerNumber == 0) {
			return (int)Math.log10(biggerNumber) + 1;
		}
		return (int)Math.log10(biggerNumber) - (int)Math.log10(smallerNumber);
	}
	
}
