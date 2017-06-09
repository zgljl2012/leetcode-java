package com.ex51_100;

import org.junit.Assert;

import com.base.Base;

public class _80_RemoveDuplicatesfromSortedArrayII extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(0, s.removeDuplicates(new int[]{}));
		Assert.assertEquals(1, s.removeDuplicates(new int[]{1}));
		Assert.assertEquals(5, s.removeDuplicates(new int[]{1,1,1,2,2,3}));
		Assert.assertEquals(6, s.removeDuplicates(new int[]{1,1,1,2,2,2,3,3,3}));
		Assert.assertEquals(6, s.removeDuplicates(new int[]{1,1,1,2,2,2,3,3,3,3}));
		Assert.assertEquals(6, s.removeDuplicates(new int[]{1,1,1,2,2,2,3,3}));
	}
	
	static public class Solution {
		
		public int removeDuplicates(int[] nums) {
	    	if(nums == null || nums.length == 0) {
	    		return 0;
	    	}
	        int index = 0;
	        for(int n:nums) {
	        	if(index < 2 || n > nums[index-2]) {
	        		nums[index++] = n;
	        	}
	        }
	        return index;
	    }
	}
	
}
