package org.wjhua.twquiz.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.wjhua.twquiz.taxrate.TaxRateCalculator;
import org.wjhua.twquiz.utils.AmountUtils;

/**
 * Goods domain object.
 * 
 * @author jinhua
 * 
 */
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3664162115500708952L;

	/*
	 * goods attribute
	 */
	private String name;

	private BigDecimal price;

	private boolean isExempt;

	private boolean isImported;

	public Goods(String name, BigDecimal price, boolean isExempt,
			boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
		this.isImported = isImported;
	}

	/**
	 * Calculate goods tax.
	 */
	private BigDecimal calculateGoodsTax(BigDecimal taxRate) {
		BigDecimal tax = BigDecimal.ZERO;
		if (taxRate.compareTo(BigDecimal.ZERO) > 0) {
			tax = getPrice().multiply(taxRate);
			tax = AmountUtils.roundAmount(tax);
		}
		return tax;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isExempt() {
		return isExempt;
	}

	public boolean isImported() {
		return isImported;
	}

	/*
	 * tax rate, tax , price
	 */
	public BigDecimal getTaxRate() {
		return TaxRateCalculator.calcTaxRate(this);
	}

	public BigDecimal getSalesTax() {
		return calculateGoodsTax(getTaxRate());
	}

	public BigDecimal getPriceWithTax() {
		return price.add(getSalesTax());
	}

}
