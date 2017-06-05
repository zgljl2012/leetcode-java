package com.ex51_100;

import com.base.Base;

public class _75_SortColors extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{0,2,1,0,2,0,1,0,1,2,2,1};
		s.sortColors(nums);
		println(nums);
	}
	
	static public class Solution {
		
		/**
		 * 因为只有3个不同的元素，所以计数排序即可
		 * 首先迭代记录0,1,2一共各有多少个数，然后按照0,1,2的顺序依次填充到数组中即可。
		 * @param nums
		 */
	    public void sortColors(int[] nums) {
	        int[] cnt = new int[3];
	        for(int i=0;i<nums.length;i++) {
	        	cnt[nums[i]]++;
	        }
	        for(int i=0,j=0;i<nums.length;i++,cnt[j]--) {
	        	while(cnt[j]==0) {
	        		j++;
	        	}
	        	nums[i] = j;
	        }
	    }
	}

}
