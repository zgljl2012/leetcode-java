package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.Base;

public class _49_GroupAnagrams extends Base {
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat","egg", "gge", "ge"};
		Solution s = new Solution();
		println(s.groupAnagrams(strs));
	}
	
	static public class Solution {
		
		/**
		 * 单词分组，将由相同字母组成的单词分到一组
		 * 字母排序算法：
		 * 将单词里的字母进行排序，这样只要字母组合相同，不同单词排序后组成的新单词都相同。
		 * @param strs
		 * @return
		 */
	    public List<List<String>> groupAnagrams1(String[] strs) {
	        Map<String, List<String>> map = new HashMap<>();
	        for(String str:strs) {
	        	char[] letters = str.toCharArray();
	        	Arrays.sort(letters);
	        	String new_str = String.valueOf(letters);
	        	if(!map.containsKey(new_str)) {
	        		map.put(new_str, new ArrayList<>());
	        	}
	        	map.get(new_str).add(str);
	        }
	        return new ArrayList<List<String>>(map.values());
	    }
	    
	    /**
	     * 素数求解算法：
	     * 使用26个素数分别表示26个小写字母，这样可以实现一个单词可以由多个素数的乘积表示，由于素数的特性，不同的单词计算出来的结果必不相同，从而一个单词可以由一个素数表示，
	     * 在比对单词时，可极大减小运算量。
	     * @param strs
	     * @return
	     */
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
	    	Map<Integer, List<String>> map = new HashMap<>();
	    	for(String str:strs) {
	    		int k = 1;
	    		for(char ch:str.toCharArray()) {
	    			k *= primes[ch-'a'];
	    		}
	    		if(!map.containsKey(k)) {
	    			map.put(k, new ArrayList<>());
	    		}
	    		map.get(k).add(str);
	    	}
	    	return new ArrayList<List<String>>(map.values());
	    }
	    
	}

}
