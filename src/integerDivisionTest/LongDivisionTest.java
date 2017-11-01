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
	public void testDivideWithNoPeriod() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(78459, 4);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 78459|4\n" + 
				"-4    |19614.75\n" + 
				" 38\n" + 
				"-36\n" + 
				"  24\n" + 
				" -24\n" + 
				"    5\n" + 
				"   -4\n" + 
				"    19\n" + 
				"   -16\n" + 
				"     30\n" + 
				"    -28\n" + 
				"      20\n" + 
				"     -20\n" + 
				"       0", divisionFormatter.formatData(divisionData));
	}
	
	@Test
	public void testDivideWithPeriod() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(100, 3);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 100|3\n" + 
				" -9 |33.(3)\n" + 
				"  10\n" + 
				"  -9\n" + 
				"   10\n" + 
				"   -9\n" + 
				"    1", divisionFormatter.formatData(divisionData));
	}
	
	@Test
	public void testDivideWithPeriodInLastDigit() {
		LongDivision test = new LongDivision();
		DivisionData divisionData = test.divide(7, 12);
		DivisionFormatter divisionFormatter = new DivisionFormatter();
		assertEquals(" 7|12\n" + 
				"-0|0.58(3)\n" + 
				" 70\n" + 
				"-60\n" + 
				" 100\n" + 
				" -96\n" + 
				"   40\n" + 
				"  -36\n" + 
				"    4", divisionFormatter.formatData(divisionData));
	}

}
