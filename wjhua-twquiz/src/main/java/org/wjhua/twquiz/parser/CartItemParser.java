package org.wjhua.twquiz.parser;

import java.math.BigDecimal;

import org.wjhua.twquiz.exception.FormatException;
import org.wjhua.twquiz.utils.AmountUtils;
import org.wjhua.twquiz.utils.ResourceUtils;
import org.wjhua.twquiz.utils.StringUtils;

/**
 * Item string parser.
 * 
 * @author jinhua
 * 
 */
public class CartItemParser {

	private static final int MIN_WORDS_LENGTH = 4;

	private static final String STRING_AT = "at";

	/*
	 * item string
	 */
	private String itemStr;

	/*
	 * item words
	 */
	private String[] words;

	public CartItemParser(String itemStr) {
		super();
		this.itemStr = itemStr;
		words = itemStr.split(StringUtils.EMPTY_STRING);
		if (words.length < MIN_WORDS_LENGTH) {
			throw new FormatException(
					"item string word is not enough, length: " + words.length);
		}
	}

	/**
	 * Get goods count by convert word and validation.
	 * 
	 * @return goods count.
	 */
	public int getGoodsCount() {
		try {
			int goodsCount = Integer.valueOf(words[0]);
			if (0 >= goodsCount) {
				throw new FormatException(itemStr
						+ ": goods count must greater than zero");
			}
			return goodsCount;
		} catch (FormatException e) {
			throw e;
		} catch (Exception e) {
			throw new FormatException(itemStr + ": get goods count error", e);
		}
	}

	/**
	 * Get goods price by convert word and validation.
	 * 
	 * @return goods price.
	 */
	public BigDecimal getGoodsPrice() {
		try {
			BigDecimal amount = new BigDecimal(words[words.length - 1]);
			AmountUtils.checkPositiveAndScale(amount);
			return amount;
		} catch (FormatException e) {
			throw e;
		} catch (Exception e) {
			throw new FormatException(itemStr + ": get goods price error", e);
		}
	}

	/**
	 * Get goods name.
	 * 
	 * @return goods name.
	 */
	public String getGoodsName() {
		return itemStr.substring(itemStr.indexOf(StringUtils.EMPTY_STRING) + 1,
				itemStr.lastIndexOf(STRING_AT) - 1);
	}

	/**
	 * exempt goods by goods words.
	 * 
	 * @return
	 */
	public boolean isExemptGoods() {
		String[] exemptWords = ResourceUtils.getExemptWords();
		for (int j = 0; j < exemptWords.length; j++) {
			if (itemStr.contains(exemptWords[j])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * imported goods by goods words.
	 * 
	 * @return
	 */
	public boolean isImportedGoods() {
		String[] importedWords = ResourceUtils.getImportedWords();
		for (int j = 0; j < importedWords.length; j++) {
			if (itemStr.contains(importedWords[j])) {
				return true;
			}
		}
		return false;
	}

}
