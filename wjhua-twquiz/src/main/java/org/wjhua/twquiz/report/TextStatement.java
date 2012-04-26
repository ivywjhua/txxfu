package org.wjhua.twquiz.report;

import org.wjhua.twquiz.domain.Cart;
import org.wjhua.twquiz.domain.CartItem;
import org.wjhua.twquiz.utils.StringUtils;

public class TextStatement extends Statement {

	@Override
	public String headString(Cart aCart) {
		return StringUtils.BLANK;
	}

	@Override
	public String eachCartItemString(CartItem aCartItem) {
		return aCartItem.getCartItemStr() + StringUtils.NEW_LINE_STR;
	}

	@Override
	public String footerString(Cart aCart) {
		return "Sales Taxes: " + aCart.getTotalSalesTaxes()
				+ StringUtils.NEW_LINE_STR + "Total: "
				+ aCart.getTotalPriceWithTax();
	}

}
