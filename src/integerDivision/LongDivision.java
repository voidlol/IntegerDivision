package integerDivision;

import java.util.ArrayList;

public class LongDivision {
	
	private static final int NUMERAL_SYSTEM = 10;
	
	public DivisionData divide(int dividend, int divider) {
		if (divider == 0) {
			return null;
		}
		DivisionData divisionData = new DivisionData(dividend, divider);
		int offset = 0;
		int resultDigit = dividend / divider;
		int difference = dividend;
		ArrayList<Integer> periodDifference = new ArrayList<>();
		while (resultDigit > NUMERAL_SYSTEM) {
			divider *= NUMERAL_SYSTEM;
			resultDigit = dividend / divider;
			offset++;
		}
		divisionData.setFirstScale(dividend, offset);
		while (offset > -9) {
			if (offset < 1) {
				if (offset == 0) {
					resultDigit = dividend / divider;
					divisionData.addResultDigit(resultDigit);
					divisionData.addSubtrahend(resultDigit * divider, offset);
					difference = dividend - resultDigit * divider;
				}
				if (difference == 0 || periodDifference.contains(difference)) {
					divisionData.addDifference(difference, offset);
					break;
				}
				periodDifference.add(difference);
				difference *= NUMERAL_SYSTEM;
				divisionData.addDifference(difference, offset);
				int periodDigit = difference / divider;
				divisionData.addPeriodDigit(periodDigit);
				divisionData.addSubtrahend(periodDigit * divider, offset);
				difference -= periodDigit * divider;
				offset--;
			}
			else {
				divisionData.addResultDigit(resultDigit);
				divisionData.addSubtrahend(resultDigit * divider, offset);
				dividend -= resultDigit * divider;
				divider /= NUMERAL_SYSTEM;
				resultDigit = dividend / divider;
				offset--;
				divisionData.addDifference(dividend, offset);
			}
		}
		
		return divisionData;
	}
}
