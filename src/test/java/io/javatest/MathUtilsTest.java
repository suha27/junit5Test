package io.javatest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils=new MathUtils();
		
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testAddFailure() {
		MathUtils mathUtils=new MathUtils();
		
		int expected = 3;
		int actual = mathUtils.add(1, 1);
		
		assertNotEquals(expected, actual);
	}
	
	@Test
	void testDivide() {
		MathUtils mathUtils = new MathUtils();
		
		assertThrows(ArithmeticException.class, 
				()->	mathUtils.divide(1, 0)
				,"Divide by Zero");
	}
	
	@Test
	void testDivideFailure() {
		MathUtils mathUtils = new MathUtils();
		
		assertThrows(ArithmeticException.class, 
				()->	mathUtils.divide(1, 10)
				,"Divide by Zero");
	}
	
	@Test
	void testComputeCircle() {
		MathUtils mathUtils=new MathUtils();
		
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Area of circle");
	}
	
	
}
