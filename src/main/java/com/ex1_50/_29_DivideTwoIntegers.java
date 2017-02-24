package com.ex1_50;

import com.base.Base;

/**
 * 解法来源于 jinwu
 * https://discuss.leetcode.com/topic/23968/clean-java-solution-with-some-comment
 */
public class _29_DivideTwoIntegers extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.divide(1, 1));
		println(s.divide(-10, 2));
		println(s.divide(1000000000, 367));
	}
	
	static public class Solution {
	    public int divide(int dividend, int divisor) {
	    	// 正负号判断
	    	int sign = ((dividend^divisor)>>31)==0?1:-1;
	    	// 将int型转为long，更方便判断溢出
	    	long ldividend = Math.abs((long)dividend);
	    	long ldivisor = Math.abs((long)divisor);
	    	// 判断divisor是否为0，若除数为0，直接返回最大值
	    	if(ldivisor==0) return Integer.MAX_VALUE;
	    	// 如果被除数为0，或者被除数小于除数，返回0
	    	if(ldividend==0||ldividend < ldivisor) return 0;
	    	
	    	long lans = ldivide(ldividend, ldivisor);
	    	
	    	int ans;
	    	if (lans > Integer.MAX_VALUE){
	    		// 处理溢出
	    		ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    	} else {
	    		ans = sign*(int) (lans);
	    	}
	    	return ans;
	    }
	    
	    public long ldivide(long ldividend, long ldivisor) {
	    	// 递归退出条件
	    	if (ldividend < ldivisor) return 0;
	    	
	    	long sum = ldivisor;
	    	long multiple = 1;
	    	while((sum+sum)<=ldividend) {
	    		sum += sum;
	    		multiple += multiple;
	    	}
	    	return multiple + ldivide(ldividend-sum, ldivisor);
	    }
	}
}
