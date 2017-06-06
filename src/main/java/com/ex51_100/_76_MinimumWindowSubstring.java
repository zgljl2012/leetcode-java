package com.ex51_100;

import com.base.Base;

public class _76_MinimumWindowSubstring extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.minWindow("abcdfghsdfsac", "cs"));
	}
	
	static public class Solution {
		
		/**
		 * 参考自https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
		 */
	    public String minWindow(String s, String t) {
	        int[] map = new int[128]; // 字符集
	        for(char ch:t.toCharArray()) {
	        	map[ch]++;
	        }
	        int cnt = t.length();
	        int begin = 0, end = 0;
	        int minLength = Integer.MAX_VALUE; // 最短窗口长度
	        int minIndex = 0; // 最短窗口开始位置
	        while(end < s.length()) {
	        	if(map[s.charAt(end++)]-- > 0) { // 如果 s[end]在t字符串之中
	        		cnt--;
	        	}
	        	while(cnt == 0) { // 已找到合法的子字符串
	        		if(end - begin < minLength) { // 更新最短窗口长度和最短窗口开始位置
	        			minLength = end - (minIndex=begin);
	        		}
	        		if(map[s.charAt(begin++)]++==0) { // 从begin开始补回去掉的t字符串中的字符
	        			cnt++;
	        		}
	        	}
	        }
	        return minLength == Integer.MAX_VALUE ? "":s.substring(minIndex, minIndex+minLength);
	    }
	}

}
