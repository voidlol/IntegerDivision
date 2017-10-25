package integerDivision;

public class LongDivision {
	
	public void divide(int dividend, int divider) {
		int result = dividend / divider;
		int dividendLength = (int) (Math.log10(dividend) + 1);
		int resultLength = (int) (Math.log10(result) + 1);
		int currentDigit = (int) (dividend % Math.pow(10, dividendLength - 1));
		System.out.println(dividend + "|" + divider);
		printSpacesNTimes(dividendLength);
		System.out.print("|" + result + "\n");
		System.out.println(currentDigit);
	}
	
	public void printSpacesNTimes(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
	}
	
}
