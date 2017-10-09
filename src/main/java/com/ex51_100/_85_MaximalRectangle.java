package com.ex51_100;

import org.junit.Test;

import com.base.Base;

import junit.framework.Assert;

public class _85_MaximalRectangle extends Base {
	
	static class Solution {
		/**
		 * 使用三个数组left[i,j]，right[i,j]，height[i,j]记录(i,j)所在矩形的左边界、右边界及高
		 * 则面积为(right[i,j] - left[i,j]) * height[i,j]，三个均使用DP算法：
		 * left[i,j] = max(left[i-1,j], cur_left)
		 * right[i,j] = min(right[i+1,j], cur_right)
		 * height[i,j] = height[i,j-1] + 1, matrix[i,j]='1'
		 *             = 0, matrix[i,j] = '0'
		 * 
		 * @param matrix
		 * @return
		 */
	    public int maximalRectangle(char[][] matrix) {
	    		if(matrix == null) return 0;
	    		int m = matrix.length;
	    		if(m==0) return 0;
	    		int n = matrix[0].length;
	    		int maxA = 0;
	        int[] right = new int[n];
	        int[] left = new int[n];
	        int[] height = new int[n];
	        for(int i=0;i<n;i++) {
	        		right[i] = n;
	        }
	        for(int i=0;i<m;i++) {
	        		int cur_left = 0, cur_right = n;
	        		for(int j=0;j<n;j++) {
	        			if(matrix[i][j] == '1') {
	        				height[j]++;
	        				left[j] = Math.max(left[j], cur_left);
	        			} else {
	        				height[j] = 0;
	        				left[j] = 0;
	        				cur_left = j+1;
	        			}
	        			if(matrix[i][n-j-1]=='1') {
	        				right[n-j-1] = Math.min(right[n-j-1], cur_right);
	        			} else {
	        				right[n-j-1] = n;
	        				cur_right = n-j-1;
	        			}
	        		}
	        		
	        		for(int j=0;j<n;j++) {
	        			maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
	        		}
	        }
	        return maxA;
	    }
	}
	
	@Test
	public void test() {
		char[][] matrix= {{'1','0','1','0','0'},
		{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'}};
		Solution s = new Solution();
		Assert.assertEquals(6, s.maximalRectangle(matrix));
		
	}
	
	@Test
	public void test1() {
		char[][] matrix= {{'1'}};
		Solution s = new Solution();
		Assert.assertEquals(1, s.maximalRectangle(matrix));
	}
	
	@Test
	public void test2() {
		char[][] matrix= {{'0','1','1'}, {'0', '1','1'}};
		Solution s = new Solution();
		Assert.assertEquals(4, s.maximalRectangle(matrix));
	}

}
