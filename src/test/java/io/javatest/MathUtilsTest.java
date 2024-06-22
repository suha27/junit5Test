package io.javatest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class MathUtilsTest {
	
	MathUtils mathUtils;
	
	TestReporter reporter;
	TestInfo info;
	@BeforeAll
	static void beforeAll() {
		System.out.println("This needs to run before all");
	}
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@BeforeEach
	void init1(TestReporter reporter, TestInfo info) {
		this.reporter = reporter;
		this.info = info;
	}
//	
//	@AfterEach
//	void cleanup() {
//		System.out.println("Clean up after each run");
//	}

	@Test
	@Tag("Math")
	@DisplayName("Add method")
	@EnabledOnOs(OS.WINDOWS)
	void testAdd() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		
		assertEquals(expected, actual);
	}
	
	@Nested
	@Tag("Math")
	@DisplayName("Subtraction tests")
	class SubtractTest{
		
		@Test
		void testSubtract() {
			int expected = 0;
			int actual = mathUtils.subtract(1, 1);
			
			assertEquals(expected, actual);
		}
		
		@Test
		void testSubtract1() {
			int expected = 10;
			int actual = mathUtils.subtract(11, 1);
			
			assertEquals(expected, actual);
		}
	}
	
	@Test
	@Tag("Math")
	@DisplayName("Multiply numbers")
	void testMultiply() {
		//int expected = 11;
		//int actual = mathUtils.multiply(11, 1);
		//assertEquals(expected, actual);
		assertAll(
				()->assertEquals(24, mathUtils.multiply(12, 2)),
				()->assertEquals(-1, mathUtils.multiply(-1,1)),
				()->assertEquals(0, mathUtils.multiply(-1,0))
				);
	}
	
	@Test
	@Tag("Math")
	void testAddFailure() {
		System.out.println("just testing "+ info.getDisplayName()+info.getTags());
		
		reporter.publishEntry("just testing "+ info.getDisplayName()+info.getTags());
		
		int expected = 3;
		int actual = mathUtils.add(1, 1);
		
		assertNotEquals(expected, actual);
	}
	
	@Test
	@Tag("Math")
	void testDivide() {
		int a = 1;
		int b= 0;
		//assertThrows(ArithmeticException.class, 
		//		()->	mathUtils.divide(a, b)
		//		,"Error expected when"+b +" is a zero Divide by Zero");
		//When concating or any resource usage in assert messages replace it by lambda
		
		assertThrows(ArithmeticException.class, 
				()->	mathUtils.divide(a, b)
				,()->"Error expected when"+b +" is a zero Divide by Zero");
	}
	
	@Test
	@Tag("Math")
	@Disabled
	void testDivideFailure() {
		assertThrows(ArithmeticException.class, 
				()->	mathUtils.divide(1, 10)
				,"Divide by Zero");
	}
	
	@Tag("Circle")
	@RepeatedTest(2)
	void testComputeCircle(RepetitionInfo info) {
		if(info.getCurrentRepetition() == info.getTotalRepetitions()) {
			System.out.println("last repetition");
		}
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Area of circle");
	}
	
	
}
