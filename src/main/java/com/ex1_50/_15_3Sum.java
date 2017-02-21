package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

/**
 * url:https://leetcode.com/problems/3sum/?tab=Description
 * Description:
 *   Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 *     Find all unique triplets in the array which gives the sum of zero.
 *   Note: The solution set must not contain duplicate triplets.
 *   For example, given array S = [-1, 0, 1, 2, -1, -4],
 *   A solution set is:
 *   [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 *   ]
 */
public class _15_3Sum extends Base {
	
	public static void main(String[] args) {
		// 暴力解法
		Solution s1 = new Solution();
		List<List<Integer>> r = s1.threeSum(new int[]{-2,0,0,2,2});
		println(r);
		
		r = s1.threeSum(new int[]{-1,0,1,2,-1,-4});
		println(r);
		
		r = s1.threeSum(new int[]{0,0,0});
		println(r);
	}
	
	static public class Solution {
		/**
		 * @param nums
		 * @return
		 */
	    public List<List<Integer>> threeSum(int[] nums) {
	    	List<List<Integer>> res = new ArrayList<>();
	    	// 给数组排序
	    	Arrays.sort(nums);
	    	for(int i=0;i<nums.length-2;i++) {
	    		if(i==0||i>0&&nums[i]!=nums[i-1]) {
	    			// 双指针法求和
	    			int l = i+1, r = nums.length-1;
	    			while(l<r) {
	    				int tmp = nums[i] + nums[l] +nums[r];
	    				if(tmp==0) {
	    					res.add(Arrays.asList(nums[i], nums[l], nums[r]));
	    					while(l<r&&nums[l] == nums[l+1]) l++;
	    					while(l<r&&nums[r] == nums[r-1]) r--;
	    					l++;r--;
	    				} else if(tmp < 0) {
	    					l++;
	    				} else {
	    					r--;
	    				}
	    			}
	    		}
	    	}
	    	return res;
	    }
	}

}
