package org.wjhua.twquiz.report;

import org.wjhua.twquiz.domain.Cart;
import org.wjhua.twquiz.domain.CartItem;
import org.wjhua.twquiz.utils.StringUtils;

public class HtmlStatement extends Statement {

	@Override
	public String headString(Cart aCart) {
		return "<H1>Price for cart</H1>\n";
	}

	@Override
	public String eachCartItemString(CartItem aCartItem) {
		return "<p>" + aCartItem.getCartItemStr() + "</p>"
				+ StringUtils.NEW_LINE_STR + "<BR/>" + StringUtils.NEW_LINE_STR;
	}

	@Override
	public String footerString(Cart aCart) {
		return "<B>Sales Taxes: " + aCart.getTotalSalesTaxes() + "</B>"
				+ StringUtils.NEW_LINE_STR + "<BR/>" + StringUtils.NEW_LINE_STR
				+ "<B>Total: " + aCart.getTotalPriceWithTax() + "</B>";
	}

}
