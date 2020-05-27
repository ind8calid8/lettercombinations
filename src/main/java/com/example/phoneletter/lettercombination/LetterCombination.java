/**
 * 
 */
package com.example.phoneletter.lettercombination;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author kannan
 *
 */
@Component
public class LetterCombination {

	private int numberOfCombinations;
	private int pages;
	private List<String> combinationList;
	
	public LetterCombination() {
		
	}

	public LetterCombination(int numberOfCombinations, int pages, List<String> combinationList) {
		super();
		this.numberOfCombinations = numberOfCombinations;
		this.pages = pages;
		this.combinationList = combinationList;
	}
	
	public int getNumberOfCombinations() {
		return numberOfCombinations;
	}
	public void setNumberOfCombinations(int numberOfCombinations) {
		this.numberOfCombinations = numberOfCombinations;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<String> getCombinationList() {
		return combinationList;
	}
	public void setCombinationList(List<String> combinationList) {
		this.combinationList = combinationList;
	}
	
	
}
