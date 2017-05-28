package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _65_ValidNumber extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(false, s.isNumber(" "));
		Assert.assertEquals(true, s.isNumber("0"));
		Assert.assertEquals(true, s.isNumber("123 "));
		Assert.assertEquals(false, s.isNumber("1a"));
		Assert.assertEquals(false, s.isNumber(" 1a "));
		Assert.assertEquals(false, s.isNumber("12 3"));
		Assert.assertEquals(true, s.isNumber("12e10"));
		Assert.assertEquals(true, s.isNumber("12e02"));
		Assert.assertEquals(true, s.isNumber("0123"));
		Assert.assertEquals(true, s.isNumber(" 123 "));
		Assert.assertEquals(true, s.isNumber(" 0.123 "));
		Assert.assertEquals(true, s.isNumber(" .123 "));
		Assert.assertEquals(true, s.isNumber(" 123. "));
		Assert.assertEquals(false, s.isNumber(" 123e "));
		Assert.assertEquals(false, s.isNumber(" e123 "));
		Assert.assertEquals(false, s.isNumber(" . "));
		Assert.assertEquals(false, s.isNumber(" .e1 "));
		Assert.assertEquals(true, s.isNumber(" -1. "));
		Assert.assertEquals(true, s.isNumber(" 2e-1 "));
		Assert.assertEquals(true, s.isNumber(" +1. "));
		Assert.assertEquals(true, s.isNumber(" 2e+1 "));
		Assert.assertEquals(false, s.isNumber(" 2e+ "));
		Assert.assertEquals(false, s.isNumber(" -. "));
		Assert.assertEquals(false, s.isNumber(" +. "));
		Assert.assertEquals(false, s.isNumber(" .- "));
		Assert.assertEquals(false, s.isNumber(" .+ "));
		Assert.assertEquals(true, s.isNumber(" -.1 "));
		Assert.assertEquals(true, s.isNumber(" +.2 "));
	}
	
	static public class Solution {
		
		// 参考自：https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
	    public boolean isNumber(String s) {
	    	s = s.trim();
	        boolean pointSeen = false;
	        boolean eSeen = false;
	        boolean numberSeen = false;
	        boolean numberAfterE = true;
	        for(int i=0; i<s.length(); i++) {
	            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	                numberSeen = true;
	                numberAfterE = true;
	            } else if(s.charAt(i) == '.') {
	                if(eSeen || pointSeen) {
	                    return false;
	                }
	                pointSeen = true;
	            } else if(s.charAt(i) == 'e') {
	                if(eSeen || !numberSeen) {
	                    return false;
	                }
	                numberAfterE = false;
	                eSeen = true;
	            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	                if(i != 0 && s.charAt(i-1) != 'e') {
	                    return false;
	                }
	            } else {
	                return false;
	            }
	        }
	        
	        return numberSeen && numberAfterE;
	    }
	}

}
