package com.ex1_50;

import com.base.Base;

public class _33_SearchInRotatedSortedArray extends Base {
	
	public static void main(String[] args) {
		Solution_2 s = new Solution_2();
		println(s.search(new int[]{5,6,7,1,2,3,4}, 2));
	}
	
	/**
	 * 直接的粗暴方法 O(n) 解题
	 * 20ms
	 * 但肯定不合题意，题目肯定是希望我们用二分查找
	 */
	public static class Solution_1 {
	    public int search(int[] nums, int target) {
	    	for(int i=0;i<nums.length;i++) {
	    		if(target == nums[i]) {
	    			return i;
	    		}
	    	}
	    	return -1;
	    }
	}
	
	/**
	 * 改进的二分查找法
	 */
	public static class Solution_2 {
		public int search(int[] nums, int target) {
			int start = 0;
			int end = nums.length-1;
			while(start<=end) {
				int mid = (start + end) / 2;
	            if (nums[mid] == target)
	                return mid;
	        
	            if (nums[start] <= nums[mid]){
	                 if (target < nums[mid] && target >= nums[start]) 
	                    end = mid - 1;
	                 else
	                    start = mid + 1;
	            } 
	        
	            if (nums[mid] <= nums[end]){
	                if (target > nums[mid] && target <= nums[end])
	                    start = mid + 1;
	                 else
	                    end = mid - 1;
	            }
			}
			return -1;
			
		}
	}

}
