package com.ex1_50;

import com.base.Base;

import junit.framework.Assert;

public class _43_MultiplyStrings extends Base {
	
	static Solution s = new Solution();
	
	public static void main(String[] args) {
		
		Assert.assertEquals("2", s.multiply("1", "2"));
		Assert.assertEquals("12", s.multiply("6", "2"));
		Assert.assertEquals("144", s.multiply("12", "12"));
		Assert.assertEquals("20", s.multiply("10", "2"));
		Assert.assertEquals("0", s.multiply("1", "0"));
		Assert.assertEquals("882", s.multiply("98", "9"));
		Assert.assertEquals("0", s.multiply("9999", "0"));
		Assert.assertEquals("0", s.multiply("0", "52"));
		Assert.assertEquals("3120", s.multiply("52", "60"));
		Assert.assertEquals("285", s.multiply("19", "15"));
		System.out.println("finished.");
	}
	
	static public class Solution {
		
		/**
		 * 按照列竖式的算法进行计算即可
		 */
	    public String multiply(String num1, String num2) {
	    	int[] product = new int[num1.length() + num2.length()];
	    	for(int i=num1.length() - 1; i>=0;i--) {
	    		int a = num1.charAt(i) - '0';
	    		for(int j = num2.length() - 1; j >=0; j--) {
	    			int b = num2.charAt(j) - '0';
	    			int cur = product.length - 2 - i - j;
	    			product[cur] += a * b;
	    			product[cur+1] += product[cur] / 10;
	    			product[cur] %= 10;
	    		}
	    	}
	    	StringBuffer sb = new StringBuffer();
	    	for(int i = product.length - 1; i > 0; i--) {
	    		if(sb.length() == 0 && product[i] == 0) {
	    			continue;
	    		}
	    		sb.append(product[i]);
	    	}
	    	sb.append(product[0]);
	    	return sb.toString();
	    }
	}
	
	static public class Solution1 {
		
		/**
		 * 按照列竖式的算法进行计算即可
		 */
	    public String multiply(String num1, String num2) {
	    	if(num1 == null) {
	    		return num2;
	    	} else if(num2 == null) {
	    		return num1;
	    	}
	        String result = "";
	        int carry = 0;
	        String s = "";
	        for(int i = num1.length() - 1; i >= 0 ; i--) {
	        	int a = num1.charAt(i) - '0';
	        	String tmp = "";
	        	for(int j = num2.length() - 1; j >= 0 ; j--) {
	        		int b = num2.charAt(j) - '0';
	        		tmp = "" + ((a * b + carry) % 10) + tmp;
	        		carry = (a * b + carry) / 10;
	        	}
	        	if(carry > 0) {
		        	tmp = "" + carry + tmp;
		        	carry = 0;
		        }
	        	tmp += s;
	        	result = add(tmp, result);
	        	s += "0";
	        }
	        // 去掉开头的0
	        StringBuffer sb = new StringBuffer(result);
	        while(sb.length() > 1 && sb.charAt(0) == '0') {
	        	sb.deleteCharAt(0);
	        }
	        return sb.toString();
	    }
	    
	    public String add(String num1, String num2) {
	    	int carry = 0;
	    	int cnt1 = num1.length() - 1, cnt2 = num2.length() - 1;
	    	String result = "";
	    	while(cnt1 >= 0 || cnt2 >= 0) {
	    		int a = cnt1 >= 0 ? num1.charAt(cnt1--) - '0' : 0;
	    		int b = cnt2 >= 0 ? num2.charAt(cnt2--) - '0' : 0;
	    		result = "" + ((a + b + carry)%10) + result;
	    		carry = (a + b + carry) / 10;
	    	}
	    	if(carry > 0) {
	    		return "" + carry + result;
	    	}
	    	return result;
	    }
	}

}
