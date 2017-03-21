package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class _39_CombinationSum extends Base {
	
	public static void main(String[] args) {
		int[] arrs = {1, 2, 3, 6, 7};
		int target = 7;
		Solution s = new Solution();
		println(s.combinationSum(arrs, target));
	}
	
	
	/**
	 * 递归解题
	 */
	static public class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    	List<List<Integer>> result = new ArrayList<>();
	    	if(candidates ==null || candidates.length == 0) {
	    		return result;
	    	}
	    	Arrays.sort(candidates);
	    	fun(result, new ArrayList<>(), 0, target, candidates);
	    	return result;
	    }
	    
	    /**
	     * @param result 结果集
	     * @param list 当前的结果数组
	     * @param cur 已经遍历到的数组指针
	     * @param target 目标数
	     */
	    public void fun(List<List<Integer>> result, List<Integer> list, int cur, int target, int[] candidates) {
	    	if(target > 0) {
	    		for(int i = cur; i < candidates.length && target >= candidates[i]; i++) {
	    			list.add(candidates[i]); // 将当前数加入到数组中
	    			fun(result, list, i, target - candidates[i], candidates);
	    			list.remove(list.size()-1);// 因为到这儿递归的一轮就结束了，最后一个数已被判断了，所以需要移除
	    		}
	    	} else if(target == 0) {
	    		result.add(new ArrayList<>(list));
	    	}
	    }
	    
	    
	}
	
}
