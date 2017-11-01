package integerDivision;

public class Main {

	public static void main(String[] args) {
		LongDivision division = new LongDivision();
		DivisionData divisionData = division.divide(355, 113);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		System.out.println(divisionFormatter.formatData(divisionData));
	}

}
