package integerDivision;

public class LongDivision {
	
	public DivisionData divide(int dividend, int divider) {
		if (divider == 0) {
			return null;
		}
		DivisionData divisionData = new DivisionData(dividend, divider);
		int offset = 0;
		int resultDigit = dividend / divider;
		while (Math.abs(resultDigit) > 10) {
			divider *= 10;
			resultDigit = dividend / divider;
			offset++;
		}
		while (offset > 0) {
			divisionData.addResultDigit(Math.abs(resultDigit));
			divisionData.addSubtrahend(resultDigit * divider, offset);
			dividend -= resultDigit * divider;
			divider /= 10;
			resultDigit = dividend / divider;
			offset--;
			divisionData.addDifference(dividend, offset);

		}
		resultDigit = dividend / divider;
		divisionData.addResultDigit(Math.abs(resultDigit));
		divisionData.addSubtrahend(resultDigit * divider, offset);
		divisionData.addDifference(dividend - resultDigit * divider, offset);
		return divisionData;
	}
}
