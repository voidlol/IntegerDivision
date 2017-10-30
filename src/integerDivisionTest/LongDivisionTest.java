package integerDivisionTest;

import static org.junit.Assert.*;

import integerDivision.DivisionData;
import integerDivision.DivisionFormatter;
import integerDivision.LongDivision;

import org.junit.Test;

public class LongDivisionTest {

	@Test
	public void testDivideDivideByZero() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(12135, 0);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals("Can't divide by zero", divisionFormatter.formatData(divisionData));
	}
	
	@Test
	public void testDivideNormalCase() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(8, 2);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 8|2\n" + 
				"-8|4\n" + 
				" 0", divisionFormatter.formatData(divisionData));
	}
	
	@Test
	public void testDivideDividerBiggerThanDividend() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(2, 8);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 2|8\n" + 
				"-0|0\n" + 
				" 2", divisionFormatter.formatData(divisionData));
	}
	
	@Test
	public void testDivideNegativeDivider() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(876, -14);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 876|-14\n" + 
					 "-84 |-62\n" + 
					 "  36\n" + 
					 " -28\n" + 
					 "   8", divisionFormatter.formatData(divisionData));
	}

}
