package com.ex1_50;

import com.base.Base;

/**
 * url: https://leetcode.com/problems/longest-valid-parentheses/?tab=Description
 */
public class _32_LongestValidParentheses extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.longestValidParentheses("()(()"));
	}
	
	/**
	 * 动态规划解题
	 * 设f[i]=n, n为以i为终点时，如果字符串有效时的长度，无效则为0
	 * 过程：
	 * 遍历字符串
	 * 	  如果 s[i]==')'
	 *     如果s[i-f[i-1]-1]=='('，则f[i] = f[i-1]+f[i-f[i-1]-2]+2;	    
	 * 如 ((()))()，
	 * f数组为：[0,0,0,2,4,6,0,8]
	 * 当 i = 4 时, s[i]==')', f[i-1]=4，所以需要减掉f[i-1]
	 * @author zgljl2012
	 *
	 */
	static public class Solution {
	    public int longestValidParentheses(String s) {
	    	int[] f = new int[s.length()];
	    	int longest = 0;
	    	for(int i=1;i<s.length();i++) {
	    		if(s.charAt(i)==')'&&i-f[i-1]-1>=0&&s.charAt(i-f[i-1]-1)=='(') {
	    			f[i] = f[i-1] + (i-f[i-1]-2>=0?f[i-f[i-1]-2]:0) + 2;
	    			if(f[i]>longest) {
	    			    longest = f[i];
	    			}
	    		}
	    	}
	    	return longest;
	    }
	}

}
