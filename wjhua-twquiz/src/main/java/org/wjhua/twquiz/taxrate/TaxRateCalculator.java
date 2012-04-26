package org.wjhua.twquiz.taxrate;

import java.math.BigDecimal;

import org.wjhua.twquiz.domain.Goods;

public class TaxRateCalculator {

	public static BigDecimal calcTaxRate(Goods goods) {
		BigDecimal currentTaxRate = BigDecimal.ZERO;
		TaxRateHandler basicHandler = new BasicTaxRateHandler();
		TaxRateHandler importedHandler = new ImportedTaxRateHandler();
		basicHandler.setNext(importedHandler);
		return basicHandler.handleTaxRate(goods, currentTaxRate);
	}

}
