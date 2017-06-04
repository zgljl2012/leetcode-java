package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _74_Searcha2DMatrix extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 3));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 1));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 50));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 23));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 11));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 10));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 30));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}, 20));
		Assert.assertEquals(false, s.searchMatrix(new int[][]{{1, 3},{10, 11},{23, 30}}, 18));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3},{10, 11},{23, 30}}, 30));
		Assert.assertEquals(false, s.searchMatrix(new int[][]{{1, 3},{10, 11},{23, 30}}, 31));
		Assert.assertEquals(false, s.searchMatrix(new int[][]{{1, 3, 5}}, 18));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5}}, 3));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1, 3, 5}}, 1));
		Assert.assertEquals(true, s.searchMatrix(new int[][]{{1}}, 1));
		Assert.assertEquals(false, s.searchMatrix(new int[][]{{1}}, 2));
		Assert.assertEquals(true, s.searchMatrix(new int[][]
				{{-8,-7,-5,-3,-3,-1,1},{2,2,2,3,3,5,7},{8,9,11,11,13,15,17},{18,18,18,20,20,20,21}}, -5));
	}
	
	static public class Solution {
		/**
		 * 矩阵搜索
		 * 从左上角开始，一行一行地进行搜索，如果这一行的最后一个数小于target，那就移到下一行；否则，就在这一行搜索target
		 * 参考自：https://discuss.leetcode.com/topic/29159/java-clear-solution
		 * @param matrix 矩阵
		 * @param target 目标值
		 * @return
		 */
	    public boolean searchMatrix(int[][] matrix, int target) {
	    	if(matrix == null || matrix.length == 0) return false;
	        int i = 0, j = matrix[0].length - 1;
	        while(i<matrix.length && j >= 0) {
	        	if(matrix[i][j] == target) {
	        		return true;
	        	} else if(matrix[i][j] < target) {
	        		i++;
	        	} else {
	        		j--;
	        	}
	        }
	        return false;
	    }
	}
	
}
