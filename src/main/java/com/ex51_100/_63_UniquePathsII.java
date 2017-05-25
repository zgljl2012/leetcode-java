package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _63_UniquePathsII extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(2, s.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
		Assert.assertEquals(0, s.uniquePathsWithObstacles(new int[][]{{0,0},{0,1}}));
		Assert.assertEquals(2, s.uniquePathsWithObstacles(new int[][]{{0,0},{0,0}}));
		Assert.assertEquals(1, s.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{1,0,0}}));
		println(s.uniquePathsWithObstacles(new int[][]{{1}}));
	}
	
	static public class Solution {
		
		/**
		 * 设f(i,j)是从(0,0)到(i,j)的路径数
		 * 同Unique Paths差不多，只是多了一个障碍物的判断
		 * 1. f(0,0) = 1
		 * 2. f(0,j) = (0,j) is obstacles ?0:f(0,j-1), 0<j<n
		 * 3. f(i,0) = (i,0) is obstacles ?0:f(i-1,0), 0<i<m
		 * 4. f(i,j) = (i,j) is obstacles ?0:f(i-1,j) + f(i, j-1), i>=1 & j>=1
		 */
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        if(m==0) return 0;
	        int n = obstacleGrid[0].length;
	        if(n==0) return 0;
	        int[][] f = new int[m][n];
	        f[0][0] = obstacleGrid[0][0]==1?0:1;
	        // 第一行
	        for(int j=1;j<n;j++) {
	        	f[0][j] = obstacleGrid[0][j]==1?0:f[0][j-1];
	        }
	        // 第一列
	        for(int i=1;i<m;i++) {
	        	f[i][0] = obstacleGrid[i][0]==1?0:f[i-1][0];
	        }
	        for(int i=1;i<m;i++) {
	        	for(int j=1;j<n;j++) {
	        		f[i][j] = obstacleGrid[i][j]==1?0:f[i-1][j] + f[i][j-1];
	        	}
	        }
	        return f[m-1][n-1];
	    }
	}

}
