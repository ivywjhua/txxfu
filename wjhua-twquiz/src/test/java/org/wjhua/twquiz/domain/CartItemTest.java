package org.wjhua.twquiz.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Focused on tax, price test. Item parse test has been tested in
 * ItemStrParserTest. Goods test has been tested in GoodsTest.
 * 
 * @author wangjinhua
 * 
 */
public class CartItemTest {

	// tax & price with tax test
	@Test
	public void test_01_s() {
		String itemStr = "1 book at 12.49";
		CartItem item = new CartItem(itemStr);
		assertEquals(BigDecimal.ZERO, item.getSalesTax());
		assertEquals(new BigDecimal("12.49"), item.getPriceWithTax());
	}

	@Test
	public void test_02_s() {
		String itemStr = "10 book at 12.49";
		CartItem item = new CartItem(itemStr);
		assertEquals(BigDecimal.ZERO, item.getSalesTax());
		assertEquals(new BigDecimal("124.90"), item.getPriceWithTax());
	}

	@Test
	public void test_03_s() {
		String itemStr = "1 music CD at 14.99";
		CartItem item = new CartItem(itemStr);
		assertEquals(new BigDecimal("1.50"), item.getSalesTax());
		assertEquals(new BigDecimal("16.49"), item.getPriceWithTax());

		itemStr = "5 music CD at 14.99";
		item = new CartItem(itemStr);
		assertEquals(new BigDecimal("7.50"), item.getSalesTax());
		assertEquals(new BigDecimal("82.45"), item.getPriceWithTax());
	}

	@Test
	public void test_04_s() {
		String itemStr = "8 imported bottle of perfume at 47.50";
		CartItem item = new CartItem(itemStr);
		assertEquals(new BigDecimal("57.20"), item.getSalesTax());
		assertEquals(new BigDecimal("437.20"), item.getPriceWithTax());

	}

	// item output string test
	@Test
	public void test_11_s() {
		String itemStr = "8 imported bottle of perfume at 47.50";
		CartItem item = new CartItem(itemStr);
		assertEquals("8 imported bottle of perfume: 437.20",
				item.getItemOutputStr());
	}

}
