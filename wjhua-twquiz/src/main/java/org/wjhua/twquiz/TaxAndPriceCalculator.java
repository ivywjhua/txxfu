package org.wjhua.twquiz;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.wjhua.twquiz.domain.Cart;
import org.wjhua.twquiz.domain.CartItem;
import org.wjhua.twquiz.utils.IOUtils;

/**
 * Tax and price calculator.
 * 
 * @author jinhua
 * 
 */
public class TaxAndPriceCalculator {

	public Cart calculateTaxAndPrice(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		try {
			return calculateTaxAndPrice(in);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	/**
	 * Calculate tax and price from inputstream.
	 * 
	 * @param in
	 * @return
	 */
	public Cart calculateTaxAndPrice(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String itemStr;
		try {
			itemStr = reader.readLine();
			Cart cart = new Cart();
			while (null != itemStr && !itemStr.isEmpty()) {
				CartItem item = new CartItem(itemStr);
				cart.addItem(item);
				itemStr = reader.readLine();
			}
			return cart;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(reader);
		}
	}

	/**
	 * Calculate tax and price interactively.
	 */
	public void calculateInteractive() {
		System.out.println("Input(empty line to exit!):");
		Scanner scan = new Scanner(System.in);
		String itemStr = scan.nextLine();

		Cart cart = new Cart();
		while (null != itemStr && !itemStr.isEmpty()) {
			CartItem item = new CartItem(itemStr);
			cart.addItem(item);
			itemStr = scan.nextLine();
		}

		System.out.println("Output:");
		System.out.println(cart.cartStr());
	}

	public static void main(String[] args) {
		TaxAndPriceCalculator main = new TaxAndPriceCalculator();
		main.calculateInteractive();
	}

}
