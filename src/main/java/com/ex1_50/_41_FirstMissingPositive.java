package com.ex1_50;

import com.base.Base;

public class _41_FirstMissingPositive extends Base {
	
	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		Solution s = new Solution();
		println(s.firstMissingPositive(nums));
	}
	
	static public class Solution {
		/**
		 * 算法：首先遍历一次进行正确的排序，然后再遍历一次，第一个不在正确位置上的数就是结果
		 * 示例：[3,4,-1,1]
		 * 3应该在[3]
		 * 4应该在[4]
		 * 1应该在[1]
		 * 遍历一次，将各个数交换到其正确的位置后得结果：
		 * [-1,1,3,4]
		 * 再遍历一次发现，第一个不在正确位置上的正数是2，返回2
		 * 
		 * @param nums
		 * @return
		 */
	    public int firstMissingPositive(int[] nums) {
	        for(int i = 0; i < nums.length; i++) {
	        	while(nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
	        		swap(nums, i, nums[i] - 1);
	        	}
	        }
	        println(nums);
	        for(int i = 0; i < nums.length; i++) {
	        	if(nums[i] != i + 1) {
	        		return i + 1;
	        	}
	        }
	        return nums.length + 1;
	    }
	    
	    public void swap(int[] nums, int i, int j) {
	    	int tmp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = tmp;
	    }
	}

}
