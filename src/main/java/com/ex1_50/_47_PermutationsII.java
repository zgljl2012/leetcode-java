package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class _47_PermutationsII extends Base {
	
	public static void main(String[] args) {
		int n[] = {1,1,2};
		Solution s = new Solution();
		println(s.permuteUnique(n));
	}
	
	static public class Solution {
		/**
		 * 深度优先遍历
		 * 参考自：
		 * https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote/13
		 * @param nums
		 * @return
		 */
	    public List<List<Integer>> permuteUnique(int[] nums) {
	    	List<List<Integer>> r = new ArrayList<>();
	        if(nums.length == 0) return r;
	        Arrays.sort(nums);
	        dfs(nums, r, new ArrayList<>(), new boolean[nums.length]);
	        return r;
	    }
	    
	    public void dfs(int[] nums, List<List<Integer>> r, List<Integer> list, boolean[] used) {
	    	if(list.size() < nums.length) {
	    		for(int i=0;i<nums.length;i++) {
		    		if(used[i] || (i>0&&nums[i]==nums[i-1]&&!used[i-1])) continue;
		    		used[i] = true;
		    		list.add(nums[i]);
		    		dfs(nums, r, list, used);
		    		used[i] = false;
		    		list.remove(list.size()-1);
		    	}
	    	} else {
	    		r.add(new ArrayList<>(list));
	    	}
	    }
	}
}
