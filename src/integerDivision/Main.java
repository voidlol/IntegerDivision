package integerDivision;

public class Main {

	public static void main(String[] args) {
		LongDivision division = new LongDivision();
		DivisionData divisionData = division.divide(876, -14);
		DivisionFormatter divisionFormatter = new DivisionFormatter(divisionData);
		System.out.println(divisionFormatter.formatData());
	}

}
