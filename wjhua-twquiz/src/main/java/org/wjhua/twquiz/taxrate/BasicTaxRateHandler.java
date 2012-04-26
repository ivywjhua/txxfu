package org.wjhua.twquiz.taxrate;

import java.math.BigDecimal;

import org.wjhua.twquiz.domain.Goods;
import org.wjhua.twquiz.utils.ResourceUtils;

public class BasicTaxRateHandler extends TaxRateHandler implements TaxRate {

	@Override
	public BigDecimal getTaxRate() {
		return ResourceUtils.getBasicTaxRate();
	}

	@Override
	public BigDecimal responseTaxRate(Goods goods) {
		if (!goods.isExempt()) {
			return getTaxRate();
		}
		return BigDecimal.ZERO;
	}

}
