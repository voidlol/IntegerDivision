package integerDivision;

public class Main {

	public static void main(String[] args) {
		LongDivision division = new LongDivision();
		DivisionData divisionData = division.divide(12135, 16);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		System.out.println(divisionFormatter.formatData(divisionData));
	}

}
