package com.ex51_100;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _54_SpiralMatrix extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] matrix= {
		                  { 1, 2, 3, 4 },
		                  { 12, 13, 14, 5},
		                  { 11, 16, 15, 6},
		                  {10,9,8,7}
		                 };
		println(s.spiralOrder(matrix));
	}
	
	static public class Solution {
		/**
		 * 获取矩阵的螺旋顺序。
		 * 使用一个指针从(0,0)开始遍历，将数添加到数组中，每次一撞墙就转向：如果当前是遍历列，就改为遍历行；当前遍历行，就改为遍历列。
		 * 使用一个布尔数组表示数是否已被遍历，如果已被遍历，其本身就变为墙。
		 * 
		 * 但控制方式很复杂。
		 */
	    public List<Integer> spiralOrder1(int[][] matrix) {
	    	List<Integer> res = new ArrayList<>();
	    	if(matrix==null||matrix.length == 0) {
	    		return res;
	    	}
	        int x = 0, y = 0, m = matrix.length, n = matrix[0].length;
	        boolean[][] visited = new boolean[m][n];
	        boolean row = false; // 方向控制，false为遍历列，true为遍历行
	        int delta = 1; // 增量，1或-1
	        while(true) {
	        	if(res.size() == m * n) {
	        		break;
	        	}
	        	res.add(matrix[x][y]);
	        	visited[x][y] = true;
	        	if(row) {
	        		if(delta==1&&x<m-1 || delta==-1&&x>0)
						x+=delta;
	        		if((delta==1&&(x==m-1||m>1&&visited[x+1][y]||m==1))||(delta==-1&&(x==0||visited[x-1][y]))) {
	        			row = false; // 转向
	        			if(y==0||visited[x][y-1]) delta=1;
	        			else if(y==n-1||visited[x][y+1]) delta=-1;
	        		}
	        	} else {
	        		if(delta==1&&y<n-1 || delta==-1&&y>0)
	        			y+=delta;
	        		if((delta==1&&(y==n-1||n>1&&visited[x][y+1]||n==1))||(delta==-1&&(y==0||visited[x][y-1]))) {
	        			row = true; // 转向
	        			if(x==0||visited[x-1][y]) delta=1;
	        			else if(x==m-1||visited[x+1][y]) delta=-1;
	        			if(n==1) x+=delta;
	        		}
	        	}
	        }
	        return res;
	    }
	    
	    /**
	     * 方法2：
	     * 参考自：https://discuss.leetcode.com/topic/3713/super-simple-and-easy-to-understand-solution
	     * 每次遍历无非是遍历一行或一列，有个开头和结尾，设为rowBegin（开始行），rowEnd（结束行），colBegin（开始列），colEnd（结束列），然后开始循环：
	     * 首先从左到右遍历（colBegin->colEnd，结束后就遍历完上面的一行了，rowBegin+1）
	     * 然后从上到下遍历（rowBegin->rowEnd，结束后就遍历完右边一列了，colEnd-1）
	     * 接着从右到左遍历（colEnd-colBegin，结束后就遍历完下面的一行了，rowEnd-1）
	     * 最后从下到上遍历（rowEnd->rowBegin，结束后就遍历完左边的一列了，colBegin+1）
	     * 一直到colBegin>colEnd并且rowBegin>rowEnd，循环结束
	     * @param matrix
	     * @return
	     */
	    public List<Integer> spiralOrder(int[][] matrix) {
	    	List<Integer> res = new ArrayList<>();
	    	if(matrix == null || matrix.length==0) {
	    		return res;
	    	}
	    	int rowBegin = 0, rowEnd = matrix.length-1;
	    	int colBegin = 0, colEnd = matrix[0].length-1;
	    	while(rowBegin<=rowEnd && colBegin<=colEnd) {
	    		// 从左到右
	    		for(int i=colBegin;i<=colEnd;i++) {
	    			res.add(matrix[rowBegin][i]);
	    		}
	    		rowBegin++;
	    		// 从上到下
	    		for(int i=rowBegin;i<=rowEnd;i++) {
	    			res.add(matrix[i][colEnd]);
	    		}
	    		colEnd--;
	    		// 从右到左
	    		if (rowBegin <= rowEnd) {
		    		for(int i=colEnd;i>=colBegin;i--) {
		    			res.add(matrix[rowEnd][i]);
		    		}
	    		}
	    		rowEnd--;
	    		// 从下到上
	    		if (colBegin <= colEnd) {
		    		for(int i=rowEnd;i>=rowBegin;i--) {
		    			res.add(matrix[i][colBegin]);
		    		}
	    		}
	    		colBegin++;
	    	}
	    	return res;
	    }
	    
	}
	
}
