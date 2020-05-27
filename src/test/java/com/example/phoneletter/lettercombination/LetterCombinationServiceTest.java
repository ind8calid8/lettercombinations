/**
 * 
 */
package com.example.phoneletter.lettercombination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;


/**
 * @author kannan
 *
 */
public class LetterCombinationServiceTest {


	@Test
	public void testGetLettersCombination() {
		LetterCombinationService service = new LetterCombinationService();
		LetterCombination lettersCombination = service.getLettersCombination(7001067);
		assertEquals(48, lettersCombination.getCombinationList().size());
	}
	
	@Test
	public void testGetLettersCombinationByPage() {
		LetterCombinationService service = new LetterCombinationService();
		List<String> lettersList = service.getLettersCombinationByPage(1034560, 2);
		assertEquals(10, lettersList.size());
	}
}
