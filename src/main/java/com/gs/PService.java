package com.gs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PService {

	@Autowired(required = true)
	private PRepository repository;

	public ArrayList<String> palindromeList(String str) {
		ArrayList<String> palindromes = new ArrayList<String>();
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			for (int j = i + 1; j <= strLen; j++) {
				StringBuilder sb = new StringBuilder(str.substring(i, j).trim());
				StringBuilder sbReverse = sb.reverse();
				boolean isPalindrome = str.substring(i, j).equals(sbReverse.toString());
				if (isPalindrome && sb.length() > 1) {
					palindromes.add(sb.toString());
				}
			}
		}
		return palindromes;
	}

	public String getLongestString(ArrayList<String> array) {
		int maxLength = 0;
		String longestString = null;
		for (String s : array) {
			if (s.length() > maxLength) {
				maxLength = s.length();
				longestString = s;
			}
		}
		return longestString;
	}

	public void save(String s, String p1) {
		PEntity pe = new PEntity();
		pe.setLargestPalindrome(p1);
		pe.set_s_(s);
		repository.save(pe);
	}

	public String fetchPalindrome() {

		ArrayList<PEntity> pel = (ArrayList<PEntity>) repository.findAll();
		String pe = null;
		if (pel.size() != 0) {
			pe = pel.get(pel.size() - 1).getLargestPalindrome();
		}

		return pe;
	}

}
