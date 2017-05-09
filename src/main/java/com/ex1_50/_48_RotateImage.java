package com.ex1_50;

import com.base.Base;

public class _48_RotateImage extends Base {
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1},{2,2,2},{3,3,3}};
		Solution s = new Solution();
		s.rotate(matrix);
		println(matrix);
	}
	
	static public class Solution {
		/**
		 * 矩阵顺时针旋转90度，位置转换为：(i,j)->(j, n-i)
		 * @param matrix
		 */
	    public void rotate1(int[][] matrix) {
	        int n = matrix.length - 1;
	        if(n<=0) {
	        	return;
	        }
	        int[][] r_matrix = new int[n+1][n+1];
	        for(int i=0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix.length;j++) {
	        		r_matrix[j][n-i] = matrix[i][j];
	        	}
	        }
	        for(int i=0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix.length;j++) {
	        		matrix[i][j] = r_matrix[i][j];
	        	}
	        }
	    }
	    
	    /**
	     * 通过两次转换达到目的，首先是将行逆序排列，然后再执行中心对称翻转，如下：
	     * 1 1 1    3 3 3    3 2 1
	     * 2 2 2 -> 2 2 2 -> 3 2 1
	     * 3 3 3    1 1 1    3 2 1
	     * @param matrix
	     */
	    public void rotate(int[][] matrix) {
	    	// 上下翻转
	    	for(int i=0;i<matrix.length/2;i++) {
	    		int[] tmp = matrix[i];
	    		matrix[i] = matrix[matrix.length-1-i];
	    		matrix[matrix.length-1-i] = tmp;
	    	}
	    	// 中心对称翻转
	    	for(int i=0;i<matrix.length;i++) {
	    		for(int j=i+1;j<matrix.length;j++) {
	    			int tmp = matrix[i][j];
	    			matrix[i][j] = matrix[j][i];
	    			matrix[j][i] = tmp;
	    		}
	    	}
	    }
	    
	    
	}
	
}
