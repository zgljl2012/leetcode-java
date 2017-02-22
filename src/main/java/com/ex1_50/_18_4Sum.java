package com.ex1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class _18_4Sum extends Base {
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2, 1}, 0));
		println(s.fourSum(new int[]{0, 0, 0, 0}, 0));
		println(s.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
	}
	
	/**
	 * 双指针求和 O(n^3)
	 * @author zgljl2012
	 */
	static public class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	    	List<List<Integer>> res = new ArrayList<>();
	    	if(nums==null) return res;
	    	Arrays.sort(nums);
	        for(int i=0;i<nums.length-3;i++) {
	        	if(i==0||i>0&&nums[i]!=nums[i-1]) {
		        	for(int j=i+1;j<nums.length-2;j++) {
		        		if(j==i+1||j>1&&nums[j]!=nums[j-1]) {
			        		int left = j+1, right = nums.length-1;
			        		while(left<right) {
			        			int tmp = nums[i]+nums[j]+nums[left]+nums[right];
			        			if(tmp == target) {
			        				res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
			        				while(left<nums.length-1&&nums[left+1]==nums[left]) left++;
			        				while(right<nums.length-1&&right>2&&nums[right]==nums[right-1]) right--;
			        				left++;
			        				right--;
			        			} else if(tmp < target) {
			        				left++;
			        			} else {
			        				right--;
			        			}
			        		}
		        		}
		        	}
	        	}
	        }
	        return res;
	    }
	}
	
	/**
	 * 在上述解法的基础上利用最大值降低计算量
	 * 数组排序后可以知道最大数max
	 * 在i这里遍历时，nums[i]是最小值，如果 nums[i]*4>target，说明i太大；如果nums[i]+3*max<target，说明i太小，前进i；
	 * j,left同理
	 * @author zgljl2012
	 */
	static public class Solution1 {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	    	List<List<Integer>> res = new ArrayList<>();
	    	if(nums==null||nums.length==0) return res;
	    	Arrays.sort(nums);
	    	int max = nums[nums.length-1];
	        for(int i=0;i<nums.length-3;i++) {
	        	if((i==0||i>0&&nums[i]!=nums[i-1])&&(nums[i]+3*max>=target)) {
		        	for(int j=i+1;j<nums.length-2;j++) {
		        		if((j==i+1||j>1&&nums[j]!=nums[j-1])&&(nums[i]+nums[j]+2*max>=target)
		        				&&(nums[i]+3*nums[j]<=target)) {
			        		int left = j+1, right = nums.length-1;
			        		if((nums[i]+nums[j]+2*nums[left]>target)||(nums[i]+nums[j]+2*max<target)) {
			        			continue;
			        		}
			        		while(left<right) {
			        			int tmp = nums[i]+nums[j]+nums[left]+nums[right];
			        			if(tmp == target) {
			        				res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
			        				while(left<nums.length-1&&nums[left+1]==nums[left]) left++;
			        				while(right<nums.length-1&&right>2&&nums[right]==nums[right-1]) right--;
			        				left++;
			        				right--;
			        			} else if(tmp < target) {
			        				left++;
			        			} else {
			        				right--;
			        			}
			        		}
		        		}
		        	}
	        	}
	        }
	    	return res;
	    }
	}

}
