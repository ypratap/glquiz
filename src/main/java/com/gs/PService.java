package com.gs;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PService {

	@Autowired
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

	public Palindrome save(Palindrome p1) {
		return repository.save(p1);

	}

}
