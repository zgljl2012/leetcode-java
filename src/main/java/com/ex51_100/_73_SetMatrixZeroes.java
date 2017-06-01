package com.ex51_100;

import com.base.Base;

public class _73_SetMatrixZeroes extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		println(matrix);
		s.setZeroes(matrix);
		println(matrix);
	}
	
	static public class Solution {
	    public void setZeroes(int[][] matrix) {
	    	if(matrix==null || matrix.length ==0) return;
	    	boolean[] rows = new boolean[matrix.length]; // 需要重置为0的行记为true，否则为false
	    	boolean[] cols = new boolean[matrix[0].length]; // 需要重置为0的列记为true，否则为false
	    	for(int i=0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix[i].length;j++) {
	        		if(matrix[i][j]==0) {
	        			rows[i] = true;
	        			cols[j] = true;
	        		}
	        	}
	        }
	    	for(int i=0;i<rows.length;i++) {
	    		if(rows[i])
	    			row2zeros(matrix, i);
	    	}
	    	for(int j=0;j<cols.length;j++) {
	    		if(cols[j])
	    			col2zeros(matrix,j);
	    	}
	    }
	    
	    private void row2zeros(int[][] matrix, int row) {
	    	for(int i=0;i<matrix[row].length;i++) {
	    		matrix[row][i] = 0;
	    	}
	    }
	    
	    private void col2zeros(int[][] matrix, int col) {
	    	for(int i=0;i<matrix.length;i++) {
	    		matrix[i][col] = 0;
	    	}
	    }
	}

}
