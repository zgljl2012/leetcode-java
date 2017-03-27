package com.ex1_50;

import com.base.Base;

import junit.framework.Assert;

public class _44_WildcardMatching extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(true, s.isMatch("a", "a"));
		Assert.assertEquals(true, s.isMatch("aa", "aa"));
		Assert.assertEquals(false, s.isMatch("aa", "a"));
		Assert.assertEquals(false, s.isMatch("a", "aa"));
		Assert.assertEquals(false, s.isMatch("aaa", "aa"));
		Assert.assertEquals(true, s.isMatch("aa", "*"));
		Assert.assertEquals(true, s.isMatch("aa", "a*"));
		Assert.assertEquals(true, s.isMatch("ab", "?*"));
		Assert.assertEquals(false, s.isMatch("aab", "c*a*b"));
		Assert.assertEquals(false, s.isMatch("aa.bbb", "*.bb"));
		Assert.assertEquals(true, s.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println("finished");
	}
	
	static public class Solution {
	    public boolean isMatch(String s, String p) {
	        int s_cur = 0;
	        int p_cur = 0;
	        int match = 0, startIdx = -1;
	        while(s_cur < s.length()) {
	        	if(p_cur < p.length() && (p.charAt(p_cur) == '?' || s.charAt(s_cur) == p.charAt(p_cur))) {
	        		p_cur++;
	        		s_cur++;
	        	} else if(p_cur < p.length() && p.charAt(p_cur) =='*') {
	        		startIdx = p_cur;
	        		match = s_cur;
	        		p_cur++;
	        	} else if(startIdx != -1) {
	        		p_cur = startIdx + 1;
	        		s_cur = match++;
	        	} else {
	        		return false;
	        	}
	        }
	        while(p_cur < p.length() && p.charAt(p_cur) == '*') {
	        	p_cur++;
	        }
	        return p_cur == p.length();
	    }
	}

}
