package integerDivisionTest;

import static org.junit.Assert.*;
import integerDivision.LongDivision;

import org.junit.Test;

public class LongDivisionTest {

	@Test
	public void testDivideDivideByZero() {
		LongDivision test = new LongDivision();
		assertEquals("Can't divide by ZERO!", test.divide(100, 0));
	}
	
	@Test
	public void testDivideNormalCase() {
		LongDivision test = new LongDivision();
		assertEquals(" 8|2\n" + 
					 "-8|4\n" + 
					 " 0\n", test.divide(8, 2));
	}
	
	@Test
	public void testDivideDividerBiggerThanDividend() {
		LongDivision test = new LongDivision();
		assertEquals("Only integer division is supported.", test.divide(2, 8));
	}
	
	@Test
	public void testDivideAnotherNormalCase() {
		LongDivision test = new LongDivision();
		assertEquals(" 876|14\n" + 
					 "-84 |62\n" + 
					 "  36\n" + 
					 " -28\n" + 
					 "   8\n", test.divide(876, 14));
	}
	
	@Test
	public void testDivideNegativeDivider() {
		LongDivision test = new LongDivision();
		assertEquals(" 876|-14\n" + 
					 "-84 |-62\n" + 
					 "  36\n" + 
					 " -28\n" + 
					 "   8\n", test.divide(876, -14));
	}

}
