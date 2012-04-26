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

	/*
	 * tax rate, tax , price
	 */
	private BigDecimal taxRate;

	private BigDecimal salesTax;

	private BigDecimal priceWithTax;
	

	public Goods(String name, BigDecimal price, boolean isExempt,
			boolean isImported) {
		super();
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
		this.isImported = isImported;

		taxRate =TaxRateCalculator.calcTaxRate(this);
		calculateGoodsTax();
		priceWithTax = price.add(salesTax);
	}

	/**
	 * Calculate goods tax.
	 */
	private void calculateGoodsTax() {
		BigDecimal tax = BigDecimal.ZERO;
		BigDecimal taxRate = getTaxRate();
		if (taxRate.compareTo(BigDecimal.ZERO) > 0) {
			tax = getPrice().multiply(taxRate);
			tax = AmountUtils.roundAmount(tax);
		}
		salesTax = tax;
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

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public BigDecimal getPriceWithTax() {
		return priceWithTax;
	}

}
