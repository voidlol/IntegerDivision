package integerDivision;

public class LongDivision {
	
	public void divide(int dividend, int divider) {
		if (divider == 0) {
			System.out.println("Can't divide by ZERO!");
			return;
		}
		if (divider > dividend) {
			System.out.println("Only integer division is supported.");
			return;
		}
		int dividendLength = (int) (Math.log10(dividend) + 1);
		int dividerLength = (int) (Math.log10(divider) + 1);
		int result = dividend / divider;
		System.out.println(" " + dividend + "|" + divider);
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
		printSpacesNTimes(calculateOffset(startDigit, multiply) - 1);
		System.out.print("-" + multiply);
		printSpacesNTimes(dividendLength  - 1 - (int)Math.log10(startDigit));
		System.out.print("|" + result + "\n");
		
		while (currentPow > 0 ) {
			currentPow--;
			currentDigit = (int)(dividend / Math.pow(10, currentPow));
			startDigit = difference * 10 + currentDigit % 10; 
			if (startDigit >= divider) {
				printSpacesNTimes(calculateOffset(currentDigit, difference));
				System.out.print(startDigit + "\n");
				multiply = startDigit / divider * divider;
				printSpacesNTimes(calculateOffset(currentDigit, multiply));
				System.out.print("-" + multiply + "\n");
				difference = startDigit - multiply;
			}
			else {
				difference = startDigit;
			}
		}
		if (difference != 0) {
			printSpacesNTimes(1);
		}
		printSpacesNTimes(calculateOffset(dividend, difference));
		System.out.print(difference + "\n");
	}
	
	public void printSpacesNTimes(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
	}
	
	public int calculateOffset(int biggerNumber, int smallerNumber) {
		if (smallerNumber == 0) {
			return (int)Math.log10(biggerNumber) + 1;
		}
		return (int)Math.log10(biggerNumber) - (int)Math.log10(smallerNumber);
	}
	
}
