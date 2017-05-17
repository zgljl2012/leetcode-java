package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _55_JumpGame extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(true, s.canJump(new int[]{2,3,1,1,4}));
		Assert.assertEquals(false, s.canJump(new int[]{3,2,1,0,4}));
		Assert.assertEquals(false, s.canJump(new int[]{0,2,3}));
		Assert.assertEquals(false, s.canJump(new int[]{}));
	}
	
	static public class Solution {
		
		/**
		 * 动态规划解题，设f(i)为在i位置能到达的最大位置：
		 * f(0) = nums[0]
		 * f(i) = max(f(i-1), i+nums[i]), f(i-1)>=i
		 *      = 0, f(i-1)<i ，此时可直接return false
		 * 最后若f(nums.length-2)>nums.length-1，则返回true；否则，返回false
		 */
	    public boolean canJump(int[] nums) {
	    	if(nums.length==0) return false;
	    	if(nums.length==1) return true;
	    	int[] f = new int[nums.length];
	    	f[0] = nums[0];
	    	for(int i=1;i<nums.length;i++) {
	    		if(i<=f[i-1]) {
	    			f[i] = Math.max(f[i-1], i+nums[i]);
	    		} else {
	    			return false;
	    		}
	    	}
	    	return f[nums.length-2]>=nums.length-1;
	    }
	}

}
