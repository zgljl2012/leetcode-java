package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class _40_CombinationSumII extends Base {
	
	public static void main(String[] args) {
		int[] arrs = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		Solution s = new Solution();
		println(s.combinationSum2(arrs, target));
	}
	
	static public class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    	List<List<Integer>> result = new ArrayList<>();
	    	Arrays.sort(candidates);
	    	fun(result, new ArrayList<>(), candidates, 0, target);
	    	return result;
	    }
	    
	    private void fun(List<List<Integer>> result, List<Integer> list, int[] candidates, int cur, int target) {
	    	if(target > 0) {
	    		for(int i=cur;i<candidates.length;i++) {
	    			if(i>cur && candidates[i] == candidates[i-1]) {
	    				continue;
	    			}
	    			list.add(candidates[i]);
	    			fun(result, list, candidates, i+1, target-candidates[i]);
	    			list.remove(list.size()-1);
	    		}
	    	} else if(target == 0) {
	    		result.add(new ArrayList<>(list));
	    	}
	    }
	}
	
}
