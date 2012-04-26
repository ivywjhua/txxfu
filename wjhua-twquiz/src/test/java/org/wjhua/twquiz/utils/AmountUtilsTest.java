package org.wjhua.twquiz.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AmountUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// null check
	@Test
	public void testRound_1() {
		thrown.expect(NullPointerException.class);
		AmountUtils.roundAmount(null);
	}

	// zero check
	@Test
	public void testRound_2() {
		BigDecimal roundAmount = AmountUtils.roundAmount(BigDecimal.ZERO);
		assertTrue(roundAmount.equals(new BigDecimal("0.00")));
	}

	// positive
	@Test
	public void testRound_3() {
		BigDecimal roundAmount1 = AmountUtils.roundAmount(new BigDecimal(
				"1.499"));
		BigDecimal roundAmount2 = AmountUtils.roundAmount(new BigDecimal(
				"7.125"));
		BigDecimal roundAmount3 = AmountUtils.roundAmount(new BigDecimal(
				"4.1985"));

		assertTrue(roundAmount1.equals(new BigDecimal("1.50")));
		assertTrue(roundAmount2.equals(new BigDecimal("7.15")));
		assertTrue(roundAmount3.equals(new BigDecimal("4.20")));
	}

	// test set scale

	// null check
	@Test
	public void testSetScale_1() {
		thrown.expect(NullPointerException.class);
		AmountUtils.setScaleAmount(null);
	}

	// zero check
	@Test
	public void testSetScale_2() {
		BigDecimal sacleAmount = AmountUtils.setScaleAmount(BigDecimal.ZERO);
		assertTrue(sacleAmount.equals(new BigDecimal("0.00")));
	}

	// negative check
	@Test
	public void testSetScale_3() {
		BigDecimal sacleAmount = AmountUtils.setScaleAmount(new BigDecimal(
				"-7.125"));
		assertTrue(sacleAmount.equals(new BigDecimal("-7.13")));
	}

	// positive check
	@Test
	public void testSetScale_4() {
		BigDecimal sacleAmount = AmountUtils.setScaleAmount(new BigDecimal(
				"7.125"));
		assertTrue(sacleAmount.equals(new BigDecimal("7.13")));
	}

}
