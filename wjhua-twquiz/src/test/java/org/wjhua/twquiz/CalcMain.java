package org.wjhua.twquiz;


public class CalcMain {
/*
	private static final String NEW_LINE_STR = "\n";
	private static final String EMPTY_STRING = " ";

	private static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.1");

//	private static final BigDecimal IMPORTED_TAX_RATE = new BigDecimal("0.05");

	private static final BigDecimal ROUND_INT_CONST = new BigDecimal("20");

	@SuppressWarnings({ "unused", "null" })
	public static void main(String[] args) {
		String[] exemptTaxGoods = { "book", "food", "medical", "chocolate" };
		String[] importedGoods = {"imported"};

		System.out.println("Input:");
		Scanner scan = new Scanner(System.in);
		String itemStr = scan.nextLine();
		BigDecimal totalSalesTaxes = new BigDecimal("0");
		BigDecimal totalPrice = new BigDecimal("0");

		StringBuilder outputBuilder = new StringBuilder("Output:\n");
		while (null != itemStr && !itemStr.isEmpty()) {
			Item item = new Item(itemStr);
			
//			Goods goods = new Goods();
			Goods goods = null;
//			item.setGoods(goods);
			
			String[] words = itemStr.split(EMPTY_STRING);

			// goods num
			String goodsCountStr = words[0];
//			item.setGoodsCount(Integer.valueOf(goodsCountStr));

			// goods name and attribute
			StringBuilder nameBuilder = new StringBuilder();
			for (int i = 1; i < words.length - 2; i++) {
				if (!goods.isExempt()) {
					for (int j = 0; j < exemptTaxGoods.length; j++) {
						if (words[i].contains(exemptTaxGoods[j])) {
							goods.setExempt(true);
						}
					}
				}
				if (!goods.isImported()) {
					for (int j = 0; j < importedGoods.length; j++) {
						goods.setImported(true);
					}
				}
				nameBuilder.append(words[i]).append(EMPTY_STRING);
			}
			String goodsName = nameBuilder.substring(0,
					nameBuilder.length() - 1);
			goods.setName(goodsName);

			// goods price
			String goodsPriceStr = words[words.length - 1];
			BigDecimal goodsPrice = new BigDecimal(goodsPriceStr);
			goods.setPrice(goodsPrice);
			
			
			BigDecimal goodsPriceWithTax;
			if (goods.isExempt()) {
				goodsPriceWithTax = goodsPrice;
			} else {
				BigDecimal basicTax = goodsPrice.multiply(BASIC_TAX_RATE);
				basicTax = new BigDecimal(Math.ceil(basicTax.multiply(
						ROUND_INT_CONST).doubleValue()))
						.divide(ROUND_INT_CONST);
				totalSalesTaxes = totalSalesTaxes.add(basicTax);
				goodsPriceWithTax = goodsPrice.add(basicTax);
				goodsPriceWithTax.setScale(2, RoundingMode.HALF_UP);
			}
			totalPrice = totalPrice.add(goodsPriceWithTax);

			outputBuilder.append(goodsCountStr).append(EMPTY_STRING)
					.append(goodsName).append(": ").append(goodsPriceWithTax)
					.append(NEW_LINE_STR);
			
			itemStr = scan.nextLine();
		}

		outputBuilder.append("Sales Taxes: ").append(totalSalesTaxes)
				.append(NEW_LINE_STR);
		outputBuilder.append("Total: ").append(totalPrice).append(NEW_LINE_STR);

		System.out.println(outputBuilder.toString());
	}
	*/
}
