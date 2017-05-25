package com.ex51_100;

import com.base.Base;

public class _62_Unique_Paths extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.uniquePaths(1, 1));
	}
	
	static public class Solution {
		
		/**
		 * 动态规划解题
		 * f(i,j)，i<m,j<n为从左上角到(i,j)的方法，则有
		 * 1. f(0,j) = 1, 0<=j<n，第一行的各个位置均只有一条路径，即一直向右走
		 * 2. f(i,0) = 1, 0<=i<m，第一列的也只有一条路径，即一直往下走
		 * 3. f(i,j) = f(i-1,j) + f(i, j-1), i>=1 & j>=1，其它位置直接来源有两条，一个是上面的往下走，一个是左边的往右走
		 */
	    public int uniquePaths(int m, int n) {
	    	if(m<=0 || n<=0) return 0;
	        int[][] f = new int[m][n];
	        for(int i=0;i<m;i++) {
	        	f[i][0] = 1;
	        }
	        for(int j=0;j<n;j++) {
	        	f[0][j] = 1;
	        }
	        for(int i=1;i<m;i++) {
	        	for(int j=1;j<n;j++) {
	        		f[i][j] = f[i-1][j] + f[i][j-1];
	        	}
	        }
	        return f[m-1][n-1];
	    }
	}
	
}
