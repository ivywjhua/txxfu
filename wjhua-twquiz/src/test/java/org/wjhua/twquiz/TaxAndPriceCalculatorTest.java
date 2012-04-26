package org.wjhua.twquiz;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Test;
import org.wjhua.twquiz.domain.Cart;
import org.wjhua.twquiz.utils.IOUtils;

public class TaxAndPriceCalculatorTest {

	@Test
	public void test_010_s() {
		testCalculateTaxAndPricePerFile("/testdata/input1.txt", new BigDecimal(
				"1.50"), new BigDecimal("29.83"));
		testCalculateTaxAndPricePerFile("/testdata/input2.txt", new BigDecimal(
				"7.65"), new BigDecimal("65.15"));
		testCalculateTaxAndPricePerFile("/testdata/input3.txt", new BigDecimal(
				"6.70"), new BigDecimal("74.68"));
	}

	@Test
	public void test_011_s() {
		TaxAndPriceCalculator main = new TaxAndPriceCalculator();
		String input = "1 imported bottle of perfume at 27.99\n"
				+ "1 bottle of perfume at 18.99\n"
				+ "1 packet of headache pills at 9.75\n"
				+ "1 box of imported chocolates at 11.25";
		Cart cart = main.calculateTaxAndPrice(input);
		assertEquals(new BigDecimal("6.70"), cart.getTotalSalesTaxes());
		assertEquals(new BigDecimal("74.68"), cart.getTotalPriceWithTax());
	}

	private void testCalculateTaxAndPricePerFile(String fileName,
			BigDecimal salesTax, BigDecimal total) {
		InputStream in = getClass().getResourceAsStream(fileName);
		try {
			TaxAndPriceCalculator calculator = new TaxAndPriceCalculator();
			Cart cart = calculator.calculateTaxAndPrice(in);
			assertEquals(salesTax, cart.getTotalSalesTaxes());
			assertEquals(total, cart.getTotalPriceWithTax());
			System.out.println("Output:");
			System.out.println(cart.getCartStr());
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

}
