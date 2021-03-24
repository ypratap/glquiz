package com.gs;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Palindrome {
	@Column
	private String _s_;

	@Column
	private String largestPalindrome;

	public String get_s_() {
		return _s_;
	}

	public void set_s_(String _s_) {
		this._s_ = _s_;
	}

	public String getLargestPalindrome() {
		return largestPalindrome;
	}

	public void setLargestPalindrome(String largestPalindrome) {
		this.largestPalindrome = largestPalindrome;
	}

}
