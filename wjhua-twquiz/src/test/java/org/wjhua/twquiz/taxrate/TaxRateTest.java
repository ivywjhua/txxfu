package org.wjhua.twquiz.taxrate;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.wjhua.twquiz.domain.Goods;

/**
 * Tax rate chain handler test.
 * 
 * @author wangjinhua
 * 
 */
public class TaxRateTest {

	private static final BigDecimal GOODS_PRICE = new BigDecimal("10");

	private static final String GOODS_NAME_STR = "goodsname";

	// one handler test
	@Test
	public void test_01_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, false, true);
		BigDecimal currentTaxRate = BigDecimal.ZERO;
		TaxRateHandler basicHandler = new BasicTaxRateHandler();
		BigDecimal taxRate = basicHandler.handleTaxRate(goods, currentTaxRate);
		assertEquals(new BigDecimal("0.1"), taxRate);
	}

	@Test
	public void test_02_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, false, true);
		BigDecimal currentTaxRate = BigDecimal.ZERO;
		TaxRateHandler importedHandler = new ImportedTaxRateHandler();
		BigDecimal taxRate = importedHandler.handleTaxRate(goods,
				currentTaxRate);
		assertEquals(new BigDecimal("0.05"), taxRate);
	}

	// two handler test.
	@Test
	public void test_03_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, true, false);
		BigDecimal currentTaxRate = BigDecimal.ZERO;
		TaxRateHandler basicHandler = new BasicTaxRateHandler();
		TaxRateHandler importedHandler = new ImportedTaxRateHandler();
		basicHandler.setNext(importedHandler);
		BigDecimal taxRate = basicHandler.handleTaxRate(goods, currentTaxRate);
		assertEquals(BigDecimal.ZERO, taxRate);
	}

	@Test
	public void test_010_s() {
		Goods goods = new Goods(GOODS_NAME_STR, GOODS_PRICE, false, true);
		BigDecimal currentTaxRate = BigDecimal.ZERO;
		TaxRateHandler basicHandler = new BasicTaxRateHandler();
		TaxRateHandler importedHandler = new ImportedTaxRateHandler();
		basicHandler.setNext(importedHandler);
		BigDecimal taxRate = basicHandler.handleTaxRate(goods, currentTaxRate);
		assertEquals(new BigDecimal("0.15"), taxRate);
	}

}
