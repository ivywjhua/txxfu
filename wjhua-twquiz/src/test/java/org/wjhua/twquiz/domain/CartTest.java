package org.wjhua.twquiz.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CartTest {

	private CartItem item1 = new CartItem("1 imported bottle of perfume at 27.99");
	private CartItem item2 = new CartItem("1 bottle of perfume at 18.99");
	private CartItem item3 = new CartItem("1 packet of headache pills at 9.75");
	private CartItem item4 = new CartItem("1 box of imported chocolates at 11.25");

	@Test
	public void test_01_s() {
		Cart cart = new Cart();
		cart.addItem(item1);
		assertEquals(new BigDecimal("4.20"), cart.getTotalSalesTaxes());
		assertEquals(new BigDecimal("32.19"), cart.getTotalPriceWithTax());
		System.out.println(cart.getCartStr());
		
		cart.addItem(item2);
		assertEquals(new BigDecimal("6.10"), cart.getTotalSalesTaxes());
		assertEquals(new BigDecimal("53.08"), cart.getTotalPriceWithTax());
		System.out.println(cart.getCartStr());

		cart.addItem(item4);
		assertEquals(new BigDecimal("6.70"), cart.getTotalSalesTaxes());
		assertEquals(new BigDecimal("64.93"), cart.getTotalPriceWithTax());
		System.out.println(cart.getCartStr());

		cart.addItem(item3);
		assertEquals(new BigDecimal("6.70"), cart.getTotalSalesTaxes());
		assertEquals(new BigDecimal("74.68"), cart.getTotalPriceWithTax());
		System.out.println(cart.getCartStr());
	}

}
