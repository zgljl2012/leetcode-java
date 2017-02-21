package com.ex401_450;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _438_FindAllAnagramsinaString extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		print(s.findAnagrams("cbaebabacd", "abc"));
		
	}
	
	static public class Solution {
	    public List<Integer> findAnagrams(String s, String p) {
	    	List<Integer> r = new ArrayList<>();
	    	if(s==null||p==null||p.length()>s.length())
	    		return r;
	    	int[] hash = new int[256];
	    	for(char ch:p.toCharArray()) {
	    		hash[ch]++;
	    	}
	    	int left=0, right=0, count = p.length();
	    	while(right < s.length()) { // ��������
	    		if(hash[s.charAt(right++)]-->=1) 
	    			count--;
	    		
	    		if(count==0) 
	    			r.add(left);
	    		
	    		if(right-left==p.length()&&hash[s.charAt(left++)]++>=0)
	    			count++;
	    	}
	    	return r;
	    }
	}
}
