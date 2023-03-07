package com.java.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {
	MathUtil m;
	// int myvar=1;

	@Test
	@DisplayName("Containt check...")
	void test() {
		// int myvar=100;
		// System.out.println(myvar);
		assertEquals("Raju", "Raju", "Correct only");

	}

	@Nested
	class MyNestedTest {

		@Test

		@DisplayName("Nested testcase..")
		public void testPositive() {

			assertEquals(2, m.add(2, 2), "This is the internal message for add event");
		}

	}

	@BeforeEach
	public void createObjectOfMathUtil() {
		m = new MathUtil();
	}

	@BeforeAll
	public void testForBeforeAll() {
		System.out.println("Lets execute this before all...");

	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Add method check...")
	void test1() {
		// MathUtil m=new MathUtil();
		int expected = 4;

		assertEquals(expected, m.add(2, 8), () -> "Just failed...as the exact value is different than " + expected);
		/*
		 * if(myvar!=100) { System.out.println("Hey What is this..."); }
		 */
	}

	@Test
	// @Disabled
	@DisplayName("devide method check...")
	void devideTest() {
		// MathUtil m=new MathUtil();
		int expected = 2;
		boolean status = false;
		Assumptions.assumeFalse(status);
		assertThrows(ArithmeticException.class, () -> m.devide(2, 0), "Devide by zero should throw an exception..");
	}

	@Test
	@DisplayName("lets check all method check...")
	void testingAll() {
		int expected = 12;
		assertAll(
				() -> assertEquals(expected, m.add(2, 10),
						"Just failed..." + expected + " is not matched with the actual"),
				() -> assertEquals(4, m.multiply(2, 2)));

	}

}
