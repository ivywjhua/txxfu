package org.wjhua.twquiz.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.wjhua.twquiz.parser.ItemStrParser;
import org.wjhua.twquiz.utils.StringUtils;

/**
 * Item for cart, one item will have one and only one goods.
 * 
 * @author jinhua
 * 
 */
public class Item implements Serializable {

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

	/*
	 * item sales tax
	 */
	private BigDecimal salesTax;

	/*
	 * item price with tax
	 */
	private BigDecimal priceWithTax;

	public Item(String itemStr) {
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
		ItemStrParser parser = new ItemStrParser(itemStr);
		goods = new Goods(parser.getGoodsName(), parser.getGoodsPrice(),
				parser.isExemptGoods(), parser.isImportedGoods());
		goodsCount = parser.getGoodsCount();

		// tax, price
		BigDecimal countBigDecimal = new BigDecimal(getGoodsCount());
		salesTax = goods.getSalesTax().multiply(countBigDecimal);
		priceWithTax = goods.getPriceWithTax().multiply(countBigDecimal);
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

	public int getGoodsCount() {
		return goodsCount;
	}

	public String getItemStr() {
		return itemStr;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public BigDecimal getPriceWithTax() {
		return priceWithTax;
	}

}
