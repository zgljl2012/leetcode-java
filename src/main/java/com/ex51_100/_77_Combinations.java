package com.ex51_100;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _77_Combinations extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.combine(4, 2));
	}
	
	static public class Solution {
		
		/**
		 * 使用回溯算法即可
		 */
	    public List<List<Integer>> combine(int n, int k) {
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	        fun(res, new ArrayList<Integer>(), 0, n, k);
	        return res;
	    }
	    
	    public void fun(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
	    	if(list.size() == k) {
	    		res.add(new ArrayList<>(list));
	    		return;
	    	}
	    	for(int i=start;i<n;i++) {
	    		list.add(i+1);
	    		fun(res, list, i+1, n, k);
	    		list.remove(list.size()-1);
	    	}
	    }
	}
}
