package com.ex1_50;

import com.base.Base;

import junit.framework.Assert;

public class _50_Pow_x_n extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(2.0, s.myPow(2, 1));
		Assert.assertEquals(4.0, s.myPow(2, 2));
		Assert.assertEquals(8.0, s.myPow(2, 3));
		Assert.assertEquals(16.0, s.myPow(2, 4));
		Assert.assertEquals(32.0, s.myPow(2, 5));
		Assert.assertEquals(0.5, s.myPow(2, -1));
		Assert.assertEquals(0.25, s.myPow(2, -2));
		Assert.assertEquals(0.125, s.myPow(2, -3));
	}
	
	static public class Solution {
		
		/**
		 * 使用递归分治算法，实现O(lgn)
		 * @param x
		 * @param n
		 * @return
		 */
	    public double myPow(double x, int n) {
	        if(n==0) return 1;
	        if(n==1) return x;
	        if(n==-1) return 1.0/x;
	        double tmp = myPow(x, n/2);
	        if(n%2==0) {
	        	return tmp*tmp;
	        }
	        if(n>0) {
	        	return tmp*tmp*x;
	        }
	        return tmp*tmp/x;
	    }
	}

}
