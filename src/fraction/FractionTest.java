/**Jinmo Chong's code
 * 
 */

package fraction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {
	
	Fraction f1;
	Fraction f2;
	Fraction f3;
	Fraction f4;
	
	@Before
	public void setUp() {
		f1 = new Fraction(4, 5);
		f2 = new Fraction(2, 5);
		f3 = new Fraction(1, -3);
		f4 = new Fraction(8, 10);
	}
	

	@Test
	public void testFraction1() {
		Fraction f5 = new Fraction(4, 5);
		assertEquals(f5, f1);
		assertEquals(f1, f4);
	}
	
	@Test(expected=ArithmeticException.class) 
	public void testBadConstruction() {
		new Fraction(1,0);
//		try {
//			Fraction fail = new Fraction(1, 0);
//			fail();
//		} catch (ArithmeticException e) {} 
	}
	
	@Test
	public void testFraction2() {
		Fraction f5 = new Fraction(4);
		Fraction f6 = new Fraction(8, 2);
		assertEquals(f5, f6);
	}
	
	@Test
	public void testFraction3() {
		Fraction f5 = new Fraction("3/5");
		Fraction f6 = new Fraction(3, 5);
		assertEquals(f5, f6);	
	}

	@Test
	public void testAdd() {
		Fraction f5 = f1.add(f2);
		Fraction f6 = new Fraction(6, 5);
		assertEquals(f5, f6);}
	
	@Test
	public void testSubtract() {
		Fraction f5 = f1.subtract(f2);
		Fraction f6 = new Fraction(2, 5);
		assertEquals(f5, f6);
	}
		
	@Test
	public void testMultiply() {
		Fraction f5 = f1.multiply(f2); // f1 = 4/5, f2 = 2/5 
		assertEquals(f5, f1.multiply(f2)); //can't understand what's happening
		Fraction f6 = new Fraction(8, 25);
		assertEquals(f5, f6);
	}
	
	@Test
	public void testDivide() {
		Fraction f5 = f1.divide(f2);
		Fraction f6 = new Fraction(4, 2);
		assertEquals(f5, f6);
	}

	@Test
	public void testAbs() {
		Fraction f5 = f3.abs();
		Fraction f6 = new Fraction(1, 3);
		assertEquals(f5, f6);
	}

	@Test
	public void testNegate() {
		Fraction f5 = f1.negate();
		Fraction f6 = new Fraction(-4, 5);
		assertEquals(f5, f6);
		
	}

	@Test
	public void testInverse() {
		Fraction f5 = f1.inverse();
		Fraction f6 = new Fraction(5, 4);
		assertEquals(f5, f6);
		Fraction f7 = f3.inverse();
		Fraction f8 = new Fraction(-3);
		assertEquals(f7, f8);
	}
	
	@Test
	public void testNormalize() {
		Fraction f5 = new Fraction(2, 4);
		Fraction f6 = new Fraction(3, 6);
		assertEquals(f5, f6);
		Fraction f7 = new Fraction(4, 8);
		assertEquals(f5, f7);
	}

	@Test
	public void testEquals() {
		assertTrue(f1.equals(f1));
		assertFalse(f1.equals(f2));
		Fraction f5 = new Fraction(8, 10);
		assertTrue(f1.equals(f5));
		assertFalse(f1.equals(f2));
	}
		
	@Test
	public void testHashCode() {
		Fraction f5 = new Fraction(5, 4);
		assertTrue(f5.hashCode() == 20);
		assertTrue(f2.hashCode() == 10);
		assertEquals(f2.hashCode(), 10);
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(f1.compareTo(f2) == 1);
		assertTrue(f3.compareTo(f4) == -1);
		assertTrue(f2.compareTo(f2) == 0);
		assertEquals(f3.compareTo(f4), -1);
	}
	
	@Test
	public void testToString() {
		assertEquals(f1.toString(), "4/5");
		System.out.println(f1);
		assertEquals(f2.toString(), "2/5");
		System.out.println(f2);
	}

}