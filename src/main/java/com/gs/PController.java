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
		String msg =  service.fetchPalindrome();
		if (msg == null)
		{
			msg = "No palindrome found";
		}
		
		return msg;
	}

	@PostMapping(path = "/{str}")
	public void addEmployee(@PathVariable(value = "str") String str) throws Exception {
		String s = service.getLongestString(service.palindromeList(str));
		
		//Store palindrome
		service.save(str, s);

	}

}
