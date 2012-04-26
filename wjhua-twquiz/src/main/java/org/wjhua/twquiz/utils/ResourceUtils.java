package org.wjhua.twquiz.utils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class ResourceUtils {

	/*
	 * exempt words
	 */
	private static final String[] EXEMPT_WORDS;

	/*
	 * imported words
	 */
	private static final String[] IMPORTED_WORDS;

	/*
	 * basic tax rate
	 */
	private static final BigDecimal BASIC_TAX_RATE;

	/*
	 * imported tax rate
	 */
	private static final BigDecimal IMPORTED_TAX_RATE;

	/**
	 * Class init block
	 */
	static {
		Properties prop = new Properties();
		InputStream in = null;
		try {
			in = ResourceUtils.class.getResourceAsStream("/twquiz.properties");
			prop.load(in);
			EXEMPT_WORDS = prop.getProperty("exempt.words").split(
					StringUtils.EMPTY_STRING);
			IMPORTED_WORDS = prop.getProperty("imported.words").split(
					StringUtils.EMPTY_STRING);
			BASIC_TAX_RATE = getBasicTaxRate0(prop);
			IMPORTED_TAX_RATE = getImportedTaxRate0(prop);
		} catch (Exception e) {
			throw new RuntimeException(
					"reading config from properties file error", e);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	/**
	 * Get and check imported tax rate.
	 * 
	 * @param prop
	 * @return imported tax rate.
	 */
	private static BigDecimal getImportedTaxRate0(Properties prop) {
		BigDecimal rate = new BigDecimal(prop.getProperty("imported.tax.rate"));
		AmountUtils.checkPositiveAndScale(rate);
		return rate;
	}

	/**
	 * Get and check basic tax rate.
	 * 
	 * @param prop
	 * @return basic tax rate.
	 */
	private static BigDecimal getBasicTaxRate0(Properties prop) {
		BigDecimal rate = new BigDecimal(prop.getProperty("basic.tax.rate"));
		AmountUtils.checkPositiveAndScale(rate);
		return rate;
	}

	public static String[] getExemptWords() {
		return EXEMPT_WORDS;
	}

	public static String[] getImportedWords() {
		return IMPORTED_WORDS;
	}

	public static BigDecimal getBasicTaxRate() {
		return BASIC_TAX_RATE;
	}

	public static BigDecimal getImportedTaxRate() {
		return IMPORTED_TAX_RATE;
	}

}
