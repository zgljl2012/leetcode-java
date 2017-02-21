package com.ex1_50;

import java.util.Arrays;

import com.base.Base;

public class _16_3SumClosest extends Base{

	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.threeSumClosest(new int[]{0,0,0}, 1));
		println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
		println(s.threeSumClosest(new int[]{0,0,2,0,-1}, 1));
	}
	
	static public class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	    	Arrays.sort(nums);
	        int closest = Integer.MAX_VALUE;
	        int gap = Integer.MAX_VALUE;
	        for(int i=0;i<nums.length;i++) {
	        	if(i==0||i>0&&nums[i]!=nums[i-1]) {
	        		int left = i+1, right=nums.length-1;
	        		while(left<right) {
	        			int tmp = nums[i]+nums[left]+nums[right];
	        			int tmp2 = Math.abs(target-tmp);
	        			if(gap>tmp2) {
	        				gap = tmp2;
	        				closest = tmp;
	        			}
	        			if(target>=tmp) {
	        				left++;
	        			} else {
	        				right--;
	        			}
	        		}
	        	}
	        }
	        return closest;
	    }
	}
}
