package integerDivision;

public class LongDivision {
	
	private static final int NUMERAL_SYSTEM = 10;
	
	public DivisionData divide(int dividend, int divider) {
		if (divider == 0) {
			return null;
		}
		DivisionData divisionData = new DivisionData(dividend, divider);
		int offset = 0;
		int resultDigit = dividend / divider;
		while (resultDigit > NUMERAL_SYSTEM) {
			divider *= NUMERAL_SYSTEM;
			resultDigit = dividend / divider;
			offset++;
		}
		divisionData.setFirstScale(dividend, offset);
		while (offset > 0) {
			divisionData.addResultDigit(resultDigit);
			divisionData.addSubtrahend(resultDigit * divider, offset);
			dividend -= resultDigit * divider;
			divider /= NUMERAL_SYSTEM;
			resultDigit = dividend / divider;
			offset--;
			divisionData.addDifference(dividend, offset);

		}
		resultDigit = dividend / divider;
		divisionData.addResultDigit(resultDigit);
		divisionData.addSubtrahend(resultDigit * divider, offset);
		divisionData.addDifference(dividend - resultDigit * divider, offset);
		return divisionData;
	}
}
