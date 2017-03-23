package com.ex1_50;

import com.base.Base;

public class _42_TrappingRainWater extends Base {
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
		println(s.trap(arr));
	}
	
	/**
	 * 解法：
	 * 左右两个指针left和right，保留一个左边最大值lmax，一个右边最大值rmax
	 * 循环比较：
	 * 当lmax <= rmax时，说明左边的当前位置肯定可以装满水，加上可以装满的水（lmax - 当前水位），左指针前移；
	 * 同理，lmax > rmax时，右边的当前位置肯定可以装满水，加上可以装满的水高度（rmax - 当前水位），右指针后移；
	 * 直到两个指针相遇。
	 */
	static public class Solution {
	    public int trap(int[] height) {
	        int r = 0;
	        int left = 0;
	        int right = height.length - 1;
	        int lmax = 0, rmax = 0;
	        while(left < right) {
	        	lmax = Math.max(lmax, height[left]);
	        	rmax = Math.max(rmax, height[right]);
	        	if(lmax <= rmax) {
	        		r += lmax - height[left];
	        		left++;
	        	} else {
	        		r += rmax - height[right];
	        		right--;
	        	}
	        }
	        return r;
	    }
	}

}
