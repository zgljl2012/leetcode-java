package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _53_MaximumSubarray extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(1, s.maxSubArray(new int[]{1}));
		Assert.assertEquals(6, s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	static public class Solution {
		
		/**
		 * 参考自：https://discuss.leetcode.com/topic/7447/o-n-java-solution
		 * 因为数组中有正数也有负数，每加一个正数，子串值增加，每加一个负数，子串值减少，所以，应该尽量跳过负数。
		 * 下面使用sum表示从左往右遍历数组时的当前较大子串和，总之，当前的那个数必须计算在sum中。sum初始化为nums[0]，接下来遍历到位置1，有如下情况：
		 * 1. 如果nums[0]>=0，则sum = sum + nums[1]
		 * 2. 如果nums[0]<0，则sum = nums[1]，
		 * 同理，有一般式：sum = nums[i] + (sum<0?0:sum)
		 * 使用max记录sum变化过程中的最大值，即为答案。
		 */
	    public int maxSubArray(int[] nums) {
	    	int max = Integer.MIN_VALUE, sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	        	sum = nums[i] + (sum < 0 ? 0:sum);
	            max = sum > max ? sum:max;
	        }
	        return max;
	    }
	}
	
}
