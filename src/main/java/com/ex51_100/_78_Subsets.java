package com.ex51_100;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _78_Subsets extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.subsets(new int[]{1,2,3}));
	}
	
	static public class Solution {
		
		/**
		 * 深度优先，回溯算法
		 */
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), nums, 0);
	        return res;
	    }
	    
	    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
	    	res.add(new ArrayList<>(list));
	    	for(int i=start;i<nums.length;i++) {
	    		list.add(nums[i]);
	    		dfs(res, list, nums, i+1);
	    		list.remove(list.size()-1);
	    	}
	    }
	}

}
