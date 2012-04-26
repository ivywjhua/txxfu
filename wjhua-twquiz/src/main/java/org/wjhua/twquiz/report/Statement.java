package org.wjhua.twquiz.report;

import org.wjhua.twquiz.domain.Cart;
import org.wjhua.twquiz.domain.CartItem;

public abstract class Statement {

	public abstract String headString(Cart aCart);

	public abstract String eachCartItemString(CartItem aCartItem);

	public abstract String footerString(Cart aCart);

	public String statement(Cart aCart) {
		StringBuilder outputBuilder = new StringBuilder(headString(aCart));
		for (CartItem aCartItem : aCart.getItems()) {
			outputBuilder.append(eachCartItemString(aCartItem));
		}
		outputBuilder.append(footerString(aCart));
		return outputBuilder.toString();
	}
}
