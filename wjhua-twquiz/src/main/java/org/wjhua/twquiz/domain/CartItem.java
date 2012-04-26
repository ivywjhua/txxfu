package org.wjhua.twquiz.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.wjhua.twquiz.parser.CartItemParser;
import org.wjhua.twquiz.utils.StringUtils;

/**
 * Item for cart, one item will have one and only one goods.
 * 
 * @author jinhua
 * 
 */
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6763870883523360279L;

	/*
	 * item attribute
	 */
	private Goods goods;

	private int goodsCount;

	private String itemStr;

	public CartItem(String itemStr) {
		super();
		this.itemStr = itemStr;
		parseItemStr();
	}

	/**
	 * Parse item string and calculate tax, price.
	 * 
	 * @param itemStr
	 */
	private void parseItemStr() {
		// parse item
		CartItemParser parser = new CartItemParser(itemStr);
		goods = new Goods(parser.getGoodsName(), parser.getGoodsPrice(),
				parser.isExemptGoods(), parser.isImportedGoods());
		goodsCount = parser.getGoodsCount();
	}

	/**
	 * Get item output string from goods attribute.
	 * 
	 * @return item output string.
	 */
	public String getItemOutputStr() {
		return getGoodsCount() + StringUtils.EMPTY_STRING + goods.getName()
				+ ": " + getPriceWithTax();
	}

	public BigDecimal getTaxRate() {
		return goods.getTaxRate();
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getItemStr() {
		return itemStr;
	}

	public BigDecimal getSalesTax() {
		BigDecimal countBigDecimal = new BigDecimal(getGoodsCount());
		return goods.getSalesTax().multiply(countBigDecimal);
	}

	public BigDecimal getPriceWithTax() {
		BigDecimal countBigDecimal = new BigDecimal(getGoodsCount());
		return goods.getPriceWithTax().multiply(countBigDecimal);
	}

}
