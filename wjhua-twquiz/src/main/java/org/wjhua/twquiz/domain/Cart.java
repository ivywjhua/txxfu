package org.wjhua.twquiz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.wjhua.twquiz.utils.StringUtils;

/**
 * Cart, may include multiple items.
 * @author jinhua
 *
 */
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585990064939265964L;

	/*
	 * Item array list.
	 */
	private List<CartItem> items = new ArrayList<CartItem>();

	public CartItem addItem(CartItem item) {
		items.add(item);
		return item;
	}

	/**
	 * Get total sales taxes from items.
	 * @return total sales taxes.
	 */
	public BigDecimal getTotalSalesTaxes() {
		BigDecimal totalSalesTaxes = BigDecimal.ZERO;
		for (CartItem item : items) {
			totalSalesTaxes = totalSalesTaxes.add(item.getSalesTax());
		}
		return totalSalesTaxes;
	}

	/**
	 * Get total price with tax from items.
	 * @return total price.
	 */
	public BigDecimal getTotalPriceWithTax() {
		BigDecimal totalPriceWithTax = BigDecimal.ZERO;
		for (CartItem item : items) {
			totalPriceWithTax = totalPriceWithTax.add(item.getPriceWithTax());
		}
		return totalPriceWithTax;
	}

	/**
	 * Get output string from items.
	 * @return cart output string.
	 */
	public String getCartStr() {
		StringBuilder outputBuilder = new StringBuilder();
		for (CartItem item : items) {
			outputBuilder.append(item.getCartItemStr()).append(
					StringUtils.NEW_LINE_STR);
		}
		outputBuilder.append("Sales Taxes: ").append(getTotalSalesTaxes())
				.append(StringUtils.NEW_LINE_STR);
		outputBuilder.append("Total: ").append(getTotalPriceWithTax())
				.append(StringUtils.NEW_LINE_STR);
		return outputBuilder.toString();
	}

}
