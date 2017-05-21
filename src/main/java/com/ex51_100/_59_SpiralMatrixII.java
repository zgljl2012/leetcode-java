package com.ex51_100;

import com.base.Base;

public class _59_SpiralMatrixII extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.generateMatrix(1));
		println(s.generateMatrix(2));
		println(s.generateMatrix(3));
		println(s.generateMatrix(4));
	}
	
	static public class Solution {
	    public int[][] generateMatrix(int n) {
	    	if(n<=0) return new int[][]{};
	    	int[][] res = new int[n][n];
	    	// 开始填入数字
	    	int rowBegin = 0, rowEnd = n-1;
	    	int colBegin = 0, colEnd = n-1;
	    	int index = 1;
	    	while(rowBegin<=rowEnd || colBegin<=colEnd) {
	    		// 从左到右
	    		for(int i=colBegin;i<=colEnd;i++) {
	    			res[rowBegin][i] = index++;
	    		}
	    		rowBegin++;
	    		// 从上到下
	    		for(int i=rowBegin;i<=rowEnd;i++) {
	    			res[i][colEnd] = index++;
	    		}
	    		colEnd--;
	    		// 从右到左
	    		if(colEnd>=colBegin) {
		    		for(int i=colEnd;i>=colBegin;i--) {
		    			res[rowEnd][i] = index++;
		    		}
	    		}
	    		rowEnd--;
	    		// 从下到上
	    		if(rowEnd >=rowBegin) {
	    			for(int i=rowEnd;i>=rowBegin;i--) {
	    				res[i][colBegin] = index++;
	    			}
	    		}
	    		colBegin++;
	    	}
	    	return res;
	    }
	}

}
