package org.wjhua.twquiz.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.wjhua.twquiz.exception.FormatException;

public class AmountUtils {

	private static final BigDecimal ROUND_INT_CONST = new BigDecimal("20");

	private static final int MAX_AMOUNT_SACLE_LENGTH = 2;

	/**
	 * Rounded up to the nearest 0.05 and set scale to 2 with half up.
	 * 
	 * @param amount
	 *            positive big decimal
	 * @return rounded big decimal
	 */
	public static BigDecimal roundAmount(BigDecimal amount) {
		amount = new BigDecimal(Math.ceil(amount.multiply(ROUND_INT_CONST)
				.doubleValue())).divide(ROUND_INT_CONST);
		return amount.setScale(MAX_AMOUNT_SACLE_LENGTH, RoundingMode.HALF_UP);
	}

	/**
	 * Set amount scale.
	 * 
	 * @param amount
	 * @return scaled amount
	 */
	public static BigDecimal setScaleAmount(BigDecimal amount) {
		return amount.setScale(MAX_AMOUNT_SACLE_LENGTH, RoundingMode.HALF_UP);
	}

	/**
	 * Check amount positive and max scale.
	 * 
	 * @param amount
	 */
	public static void checkPositiveAndScale(BigDecimal amount) {
		if (amount.scale() > MAX_AMOUNT_SACLE_LENGTH) {
			throw new FormatException(amount + ": amount scale overflow");
		}
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new FormatException(amount
					+ ": amount must greater than zero");
		}
	}
}
