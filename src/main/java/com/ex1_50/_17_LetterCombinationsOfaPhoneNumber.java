package com.ex1_50;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _17_LetterCombinationsOfaPhoneNumber extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.letterCombinations("23"));
		println(s.letterCombinations(""));
		println(s.letterCombinations("2"));
	}
	
	static public class Solution {
		
		public String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		
	    public List<String> letterCombinations(String digits) {
	    	List<String> res = new ArrayList<>();
	    	if("".equals(digits)) return res;
	    	combine(digits, 0, "", res);
	    	return res;
	    }
	    
	    public void combine(String digits, int pos, String prefix, List<String> res) {
	    	if(pos >= digits.length()) {
	    		res.add(prefix);
	    		return;
	    	}
	    	String tmp = mapping[Character.getNumericValue(digits.charAt(pos))];
	    	for(Character ch:tmp.toCharArray()) {
	    		combine(digits, pos+1, prefix+ch, res);
	    	}
	    }
	}
	
}
