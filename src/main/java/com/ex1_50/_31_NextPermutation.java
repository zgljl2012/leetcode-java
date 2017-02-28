package com.ex1_50;

import com.base.Base;

/**
 * url：https://leetcode.com/problems/next-permutation/?tab=Description
 */
public class _31_NextPermutation extends Base {
	
	public static void main(String[] args) {
		int[] nums = {1,1,5};
		Solution s = new Solution();
		s.nextPermutation(nums);
		println(nums);
		s.nextPermutation(nums);
		println(nums);
	}
	
	static public class Solution {
	    public void nextPermutation(int[] nums) {
	    	if(nums==null||nums.length==0) return;
	        int pos = nums.length-1;
	        while(pos>0&&nums[pos-1]>=nums[pos]) {
	        	pos--;
	        }
	        if(pos==0) {
	        	reverse(nums, 0, nums.length-1);
	        	return;
	        }
	        int i = nums.length-1;
	        while(i>pos&&nums[i]<=nums[pos-1]) {
	        	i--;
	        }
	        swap(nums, i, pos-1); // 找到pos-1在后半截的位置并置入，此时后半截已经是降序排序的数组了
	        reverse(nums, pos, nums.length-1);
	        
	    }
	    
	    public void swap(int[] nums, int i, int j) {
	    	int tmp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = tmp;
	    }
	    
	    public void reverse(int[] nums, int i, int j) {
	    	while(i<j) {
	    		swap(nums, i++, j--);
	    	}
	    }
	}

}
