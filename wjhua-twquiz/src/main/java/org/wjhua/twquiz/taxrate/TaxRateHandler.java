package org.wjhua.twquiz.taxrate;

import java.math.BigDecimal;

import org.wjhua.twquiz.domain.Goods;

/**
 * Handler for calculating tax rate from goods attribute.
 * 
 * @return totalTaxRate
 */
public abstract class TaxRateHandler {

	/*
	 * Next handler.
	 */
	private TaxRateHandler nextHandler;

	/**
	 * Handle tax rate by goods, current tax rate and next handler.
	 * 
	 * @param goods
	 * @param currentTaxRate
	 * @return tax rate.
	 */
	public final BigDecimal handleTaxRate(Goods goods, BigDecimal currentTaxRate) {
		BigDecimal taxRate = this.responseTaxRate(goods);
		currentTaxRate = currentTaxRate.add(taxRate);
		if (null != nextHandler) {
			currentTaxRate = nextHandler.handleTaxRate(goods, currentTaxRate);
		}
		return currentTaxRate;
	}

	/**
	 * Set next handler.
	 * 
	 * @param handler
	 */
	public void setNext(TaxRateHandler handler) {
		this.nextHandler = handler;
	}

	/**
	 * Return tax rate by goods.
	 * 
	 * @param goods
	 * @return tax rate.
	 */
	public abstract BigDecimal responseTaxRate(Goods goods);
}
