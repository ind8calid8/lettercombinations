/**
 * 
 */
package com.example.phoneletter.lettercombination;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kannan
 *
 */
@RestController
@RequestMapping(path = "/letters/{number}")
public class LetterCombinationController {
	@Autowired
	private LetterCombinationService letterService;
	
	Logger logger = LoggerFactory.getLogger(LetterCombinationController.class);

	@GetMapping()
	public LetterCombination getLetterCombinations(@PathVariable long number) throws Exception {
		logger.info("The input is " + number);
		int length = (int) (Math.log10(number) + 1);
		if (length == 7 || length == 10) {
			return letterService.getLettersCombination(number);
		}
		
		throw new RuntimeException("Length is not valid");
		
	}
	
	@GetMapping(value = "/page/{pageId}")
	public List<String> getLetterCombinationsByPage(@PathVariable long number, @PathVariable int pageId) throws Exception {
		logger.info("The input is " + number);
		int length = (int) (Math.log10(number) + 1);
		if (length == 7 || length == 10) {
			return letterService.getLettersCombinationByPage(number, pageId);
		}
		
		throw new RuntimeException("Length is not valid");
		
	}
}
