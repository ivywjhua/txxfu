package org.wjhua.twquiz.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class GoodsTest {

	private static final BigDecimal GOODS_PRICE = new BigDecimal("10");
	private static final String GOODS_NAME_STR = "goodsname";

	// tax rate test
	@Test
	public void test_01_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, true, true);
		assertEquals(new BigDecimal("0.05"), goods.getTaxRate());
	}

	@Test
	public void test_02_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, false, true);
		assertEquals(new BigDecimal("0.15"), goods.getTaxRate());
	}

	@Test
	public void test_03_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, false, false);
		assertEquals(new BigDecimal("0.1"), goods.getTaxRate());
	}

	@Test
	public void test_04_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, true, false);
		assertEquals(BigDecimal.ZERO, goods.getTaxRate());
	}

	// tax and price with tax
	@Test
	public void test_05_s() {
		Goods goods = new Goods(GOODS_NAME_STR, new BigDecimal("47.5"), false,
				true);
		assertEquals(new BigDecimal("7.15"), goods.getSalesTax());
		assertEquals(new BigDecimal("54.65"), goods.getPriceWithTax());
	}

}
