package com.ex1_50;

import com.base.Base;

public class _34_SearchForaRange extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.searchRange(new int[]{5, 7, 8, 8,8, 10}, 8));
	}
	
	static public class Solution {
	    public int[] searchRange(int[] nums, int target) {
	    	int start = firstGreaterEqual(nums, target);
			if (start == nums.length || nums[start] != target) {
				return new int[]{-1, -1};
			}
			return new int[]{start, Solution.firstGreaterEqual(nums, target + 1) - 1};
	    }
	    
	    /**
	     * 找到第一个大于等于target的数
	     * @param nums
	     * @param target
	     * @return
	     */
	    private static int firstGreaterEqual(int[] nums, int target) {
			int low = 0, high = nums.length;
			while (low < high) {
				int mid = (high + low) /2;
				if (nums[mid] < target) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			return low;
		}
	}

}
