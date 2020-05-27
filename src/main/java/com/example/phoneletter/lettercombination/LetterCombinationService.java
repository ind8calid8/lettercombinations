/**
 * 
 */
package com.example.phoneletter.lettercombination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kannan
 *
 */
@Service
public class LetterCombinationService {
	
	@Autowired
	private LetterCombination letterCombination;
	
	public LetterCombination getLettersCombination(long number) {
		char[] numbers = String.valueOf(number).toCharArray();
		List<String> combinationList = new ArrayList<>();
		combinationList.add("");
		for (int i=0; i<numbers.length; i++) {
			combinationList = addToList(getCharacterList(numbers[i]), combinationList);
		}
		
		if (combinationList.size()%10 != 0) {
			letterCombination = new LetterCombination(combinationList.size(), combinationList.size()/10 + 1, combinationList); 
		} else {
			letterCombination = new LetterCombination(combinationList.size(), combinationList.size()/10 , combinationList);
		}
			
		return letterCombination;
	}
	
	public List<String> getLettersCombinationByPage(long number, int pageId) {
		char[] numbers = String.valueOf(number).toCharArray();
		List<String> combinationList = new ArrayList<>();
		combinationList.add("");
		for (int i=0; i<numbers.length; i++) {
			combinationList = addToList(getCharacterList(numbers[i]), combinationList);
		}
		
		int pages = combinationList.size()/10;
		if (combinationList.size()%10 != 0) {
			pages += 1;
		} 
		
		if (pageId > pages || pageId <= 0) {
			throw new RuntimeException("Invalid Page Number");
		}
		
		int limit = pageId*10 > combinationList.size() ? combinationList.size(): pageId*10;
		List<String> filteredList = new ArrayList<>();
		for (int i=pageId*10-10; i<limit; i++) {
			filteredList.add(combinationList.get(i));
		}
			
		return filteredList;
	}
	
	public Character[] getCharacterList(char x) {
		Character[] chars;
		
		switch (x)
	    {
	        case '0': chars = new Character[] { '0' };
	            return chars;
	        case '1': chars = new Character[] { '1' };
	            return chars;
	        case '2': chars = new Character[] { 'a', 'b', 'c' };
	            return chars;
	        case '3': chars = new Character[] { 'd', 'e', 'f' };
	            return chars;
	        case '4': chars = new Character[] { 'g', 'h', 'i' };
	            return chars;
	        case '5': chars = new Character[] { 'j', 'k', 'l' };
	            return chars;
	        case '6': chars = new Character[] { 'm', 'n', 'o' };
	            return chars;
	        case '7': chars = new Character[] { 'p', 'q', 'r', 's' };
	            return chars;
	        case '8': chars = new Character[] { 't', 'u', 'v' };
	            return chars;
	        case '9': chars = new Character[] { 'w', 'x', 'y', 'z' };
	            return chars;
	        default: return null;
	    }

	}

	private List<String> addToList(Character[] chars, List<String> combinationList) {
		List<String> lettersList = new ArrayList<>();
		for (int i=0; i<combinationList.size(); i++) {
			for(int j=0; j<chars.length; j++) {
				lettersList.add(combinationList.get(i) + chars[j]);
			}
		}
		
		combinationList = lettersList;
		return combinationList;
	}

}
