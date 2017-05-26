package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _64_MinimumPathSum extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(1,s.minPathSum( new int[][]{{1}}));
		Assert.assertEquals(1,s.minPathSum( new int[][]{{0,1}}));
		Assert.assertEquals(2,s.minPathSum( new int[][]{{0,1},{2,1}}));
		Assert.assertEquals(3,s.minPathSum( new int[][]{{0,1,2},{2,1,1}}));
		Assert.assertEquals(1,s.minPathSum( new int[][]{{1,0,3},{4,0,6},{7,0,0}}));
	}
	
	static public class Solution {
		
		/**
		 * 矩阵m x n，从左上角到右下角有很多条路径，每个位置都有一个数字，求路径上数字之和的最小值
		 * 设f(i,j)表示从(0,0)到(i,j)的所有路径上数字之和中的最小值，则有：
		 * 1. f(0,0) = grid[0][0]
		 * 2. f(i,0) = f(i-1,0) + grid[i-1][0],0<i<m，第一列
		 * 3. f(0,j) = f(0,j-1) + grid[0][j-1],0<j<n，第一行
		 * 4. f(i,j) = min(f(i-1,j), f(i,j-1)) + grid[i][j]，1<=i<m, 1<=j<n
		 */
	    public int minPathSum(int[][] grid) {
	        int m = grid.length;
	        if(m==0) return 0;
	        int n = grid[0].length;
	        if(n==0) return 0;
	        int[][] f = new int[m][n];
	        f[0][0] = grid[0][0];
	        for(int i=1;i<m;i++) {
	        	f[i][0] = f[i-1][0] + grid[i][0];
	        }
	        for(int j=1;j<n;j++) {
	        	f[0][j] = f[0][j-1] + grid[0][j];
	        }
	        for(int i=1;i<m;i++) {
	        	for(int j=1;j<n;j++) {
	        		f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
	        	}
	        }
	        return f[m-1][n-1];
	    }
	}

}
