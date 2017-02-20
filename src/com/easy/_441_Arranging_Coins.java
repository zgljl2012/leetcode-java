package com.easy;

import com.base.Base;

public class _441_Arranging_Coins extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.arrangeCoins(5));
		println(s.arrangeCoins(8));
		println(s.arrangeCoins(1804289383));
	}
	
	static public class Solution {
	    public int arrangeCoins(int n) {
	        // i^2 + i -2n >= 0
	    	// i = (-1 + sqrt(1+8n)/2)
	    	return (int) ((-1 + Math.sqrt(1+8*(long)n))/2.0);
	    }
	}

}
