package org.wjhua.twquiz.parser;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.wjhua.twquiz.exception.FormatException;

public class ItemStrParserTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// constructor test normal
	@Test
	public void test_011_f() {
		thrown.expect(NullPointerException.class);
		@SuppressWarnings("unused")
		ItemStrParser parser = new ItemStrParser(null);
	}

	@Test
	public void test_012_f() {
		String itemStr = "1book at 12.49";
		thrown.expect(FormatException.class);
		@SuppressWarnings("unused")
		ItemStrParser parser = new ItemStrParser(itemStr);
	}

	@Test
	public void test_013_s() {
		String itemStr = "1 book at 12.49";
		@SuppressWarnings("unused")
		ItemStrParser parser = new ItemStrParser(itemStr);
	}

	// get goods count test
	@Test
	public void test_021_f() {
		String itemStr = "1a book at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		thrown.expect(FormatException.class);
		parser.getGoodsCount();
	}

	@Test
	public void test_022_f() {
		String itemStr = "0 book at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		thrown.expect(FormatException.class);
		parser.getGoodsCount();
	}

	@Test
	public void test_023_f() {
		String itemStr = "10 book at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(10, parser.getGoodsCount());
	}

	// get goods price test
	@Test
	public void test_031_f() {
		String itemStr = "10 book at 12.49a";
		ItemStrParser parser = new ItemStrParser(itemStr);
		thrown.expect(FormatException.class);
		parser.getGoodsPrice();
	}

	@Test
	public void test_032_f() {
		String itemStr = "10 book at -12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		thrown.expect(FormatException.class);
		parser.getGoodsPrice();
	}

	@Test
	public void test_033_f() {
		String itemStr = "10 book at 12.499";
		ItemStrParser parser = new ItemStrParser(itemStr);
		thrown.expect(FormatException.class);
		parser.getGoodsPrice();
	}

	@Test
	public void test_034_s() {
		String itemStr = "10 book at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(new BigDecimal("12.49"), parser.getGoodsPrice());
	}

	@Test
	public void test_035_s() {
		String itemStr = "10 book at 12";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(new BigDecimal("12"), parser.getGoodsPrice());
	}

	// get goods name test
	@Test
	public void test_041_s() {
		String itemStr = "10 imported bottle of perfume at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals("imported bottle of perfume", parser.getGoodsName());
	}

	@Test
	public void test_042_s() {
		String itemStr = "10 s at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals("s", parser.getGoodsName());
	}

	// is exempt goods test
	@Test
	public void test_051_s() {
		String itemStr = "10 s at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertFalse(parser.isExemptGoods());
	}
	
	@Test
	public void test_052_s() {
		String itemStr = "10 packet of headache pills at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertTrue(parser.isExemptGoods());
	}

	// is imported goods test
	@Test
	public void test_061_s() {
		String itemStr = "10 packet of headache pills at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertFalse(parser.isImportedGoods());
	}
	
	@Test
	public void test_062_s() {
		String itemStr = "10 box of imported chocolates at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertTrue(parser.isImportedGoods());
		assertTrue(parser.isExemptGoods());
	}

	// combination test
	@Test
	public void test_1() {
		String itemStr = "1 book at 12.49";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(1, parser.getGoodsCount());
		assertEquals(new BigDecimal("12.49"), parser.getGoodsPrice());
		assertEquals("book", parser.getGoodsName());
		assertTrue(parser.isExemptGoods());
		assertFalse(parser.isImportedGoods());
	}

	@Test
	public void test_2() {
		String itemStr = "1 music CD at 14.99";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(1, parser.getGoodsCount());
		assertEquals(new BigDecimal("14.99"), parser.getGoodsPrice());
		assertEquals("music CD", parser.getGoodsName());
		assertFalse(parser.isExemptGoods());
		assertFalse(parser.isImportedGoods());
	}

	@Test
	public void test_3() {
		String itemStr = "1 imported box of chocolates at 10.00";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(1, parser.getGoodsCount());
		assertEquals(new BigDecimal("10.00"), parser.getGoodsPrice());
		assertEquals("imported box of chocolates", parser.getGoodsName());
		assertTrue(parser.isExemptGoods());
		assertTrue(parser.isImportedGoods());
	}

	@Test
	public void test_4() {
		String itemStr = "1 packet of headache pills at 9.75";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(1, parser.getGoodsCount());
		assertEquals(new BigDecimal("9.75"), parser.getGoodsPrice());
		assertEquals("packet of headache pills", parser.getGoodsName());
		assertTrue(parser.isExemptGoods());
		assertFalse(parser.isImportedGoods());
	}

	@Test
	public void test_5() {
		String itemStr = "1 box of imported chocolates at 11.25";
		ItemStrParser parser = new ItemStrParser(itemStr);
		assertEquals(1, parser.getGoodsCount());
		assertEquals(new BigDecimal("11.25"), parser.getGoodsPrice());
		assertEquals("box of imported chocolates", parser.getGoodsName());
		assertTrue(parser.isExemptGoods());
		assertTrue(parser.isImportedGoods());
	}

}
