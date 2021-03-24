package com.gs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class PController {

	@Autowired
	private PService service;

	@GetMapping(path = "/")
	public String getPalindrome() {
		return "Hellow";
	}

	@PostMapping(path = "/{str}")

	// public String addEmployee(@RequestBody(required = false) Palindrome str)
	// throws Exception {
	public void addEmployee(@PathVariable(value = "str") String str) throws Exception {
		String s = service.getLongestString(service.palindromeList(str));
		// new
		// Palindrome(setLargestPalindrome(service.getLongestString(service.palindromeList(s))));

		// PService.save();
	}

}
