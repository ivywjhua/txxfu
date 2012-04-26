package org.wjhua.twquiz.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class ResourceUtilsTest {

	@Test
	public void testGetExemptWords() {
		String[] exemptWords = ResourceUtils.getExemptWords();
		assertNotNull(exemptWords);
		assertTrue(exemptWords.length > 0);
	}

	@Test
	public void testGetImportedWords() {
		String[] importedWords = ResourceUtils.getImportedWords();
		assertNotNull(importedWords);
		assertTrue(importedWords.length > 0);
	}

	@Test
	public void testGetBasicTaxRate() {
		BigDecimal basicTaxRate = ResourceUtils.getBasicTaxRate();
		assertNotNull(basicTaxRate);
	}

	@Test
	public void testGetImportedTaxRate() {
		BigDecimal importedTaxRate = ResourceUtils.getImportedTaxRate();
		assertNotNull(importedTaxRate);
	}

}
