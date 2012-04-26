package org.wjhua.twquiz.taxrate;

import java.math.BigDecimal;

import org.wjhua.twquiz.domain.Goods;
import org.wjhua.twquiz.utils.ResourceUtils;

public class ImportedTaxRateHandler extends TaxRateHandler implements TaxRate {

	@Override
	public BigDecimal getTaxRate() {
		return ResourceUtils.getImportedTaxRate();
	}

	@Override
	public BigDecimal responseTaxRate(Goods goods) {
		if (goods.isImported()) {
			return getTaxRate();
		}
		return BigDecimal.ZERO;
	}

}
