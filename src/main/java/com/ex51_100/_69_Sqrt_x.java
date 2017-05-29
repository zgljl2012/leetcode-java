package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _69_Sqrt_x extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(0, s.mySqrt(0));
		Assert.assertEquals(1, s.mySqrt(1));
		Assert.assertEquals(1, s.mySqrt(2));
		Assert.assertEquals(2, s.mySqrt(4));
		Assert.assertEquals(1, s.mySqrt(3));
		Assert.assertEquals(10, s.mySqrt(100));
		Assert.assertEquals(46339, s.mySqrt(2147395599));
	}
	
	static public class Solution {
		
		/**
		 * 使用折半查找即可
		 */
	    public int mySqrt(int x) {
	    	int left = 1, right = x;	    	
	    	while(left<=right) {
	    		int mid = left + (right-left)/2;// 不能使用(right+left)，因为有可能整数溢出
	    		if(mid <= x/mid) {
	    			left = mid + 1;
	    		} else {
	    			right = mid - 1;
	    		}
	    	}
	    	return left-1;
	    }
	}
	
}
