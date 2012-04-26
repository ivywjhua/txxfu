package org.wjhua.twquiz;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE / 1000);
		System.out.println(Long.MAX_VALUE / 1000);
		System.out.println(Math.ceil(1.499));
		System.out.println(Math.ceil(1.500));
		System.out.println(Math.ceil(1.501));
		System.out.println(Math.ceil(1.001));
		System.out.println(Math.ceil(1.000));
	}

	@Test
	public void testMathCeil() {
		assertEquals(String.valueOf(2.0), String.valueOf(Math.ceil(1.499)));
		assertEquals(String.valueOf(2.0), String.valueOf(Math.ceil(1.500)));
		assertEquals(String.valueOf(2.0), String.valueOf(Math.ceil(1.501)));
		assertEquals(String.valueOf(2.0), String.valueOf(Math.ceil(1.001)));
		assertEquals(String.valueOf(1.0), String.valueOf(Math.ceil(1.000)));
		assertEquals(1, 1);
	}
}
