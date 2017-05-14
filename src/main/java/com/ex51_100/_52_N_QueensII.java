package com.ex51_100;

import com.base.Base;

public class _52_N_QueensII extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.totalNQueens(8));
	}
	
	static public class Solution {
		
		/**
		 * 返回N-皇后问题的解法数
		 * @param n
		 * @return
		 */
	    public int totalNQueens(int n) {
	    	//return solve1(new int[n], n, 0);
	    	return solve2(0, new boolean[n], new boolean[2*n], new boolean[2*n], n);
	    }
	    
	    /**
	     * 解法1：因为皇后不能在同一行中，所以可以排除掉行这一因素，所以可以使用一个数组c[n]来表示皇后的放法，如c[i]=j，表示第i行的皇后在j列
	     * 则判断皇后位置是否冲突的方法就只需要判断是否在同一列或同一斜线，如果c[a]=c[b]，则第a行的皇后与第b行的皇后在同一列中；
	     * 如果|a-b|=|c[a]-c[b]|，则a和b之间行的差等于列的差，说明两者在同一斜线。有了判断冲突的方法，接下来就只需要使用递归回溯方法即可解决问题。
	     *
	     */
	    public int solve1(int[] c, int n, int index) {
	    	if(index == n) {
	    		return 1;
	    	}
	    	int num = 0;
	    	// 从第一列开始遍历
	    	for(int j=0;j<n;j++) {
	    		c[index] = j; // 将第index行的皇后放在第j列
	    		boolean has = false; // 是否有冲突标志位
	    		// 遍历当前已放置好的皇后，看是否有冲突
	    		for(int i=0;i<index;i++) {
	    			if(c[i] == c[index] || Math.abs(i-index)==Math.abs(c[i]-c[index])) {
	    				has = true;
	    			}
	    		}
	    		if(!has) {
	    			// 如果没有冲突，当前解法可行，增加一位皇后
	    			num += solve1(c, n, index+1);
	    		}
	    	}
	    	return num;
	    }
	    
	    /**
	     * 解法2：对于判断皇后的冲突，还可以使用下面这种判断方法.首先还是从行开始遍历，每遍历到一行，就依次遍历这一行的每个位置，即每一列，看是否符合要求，
	     * 因为两个皇后不能在同一列，所以可以使用一个数组cols[n]表示这一列是否已经有了皇后，如cols[i]表示第i行已经有了皇后；
	     * 接下来是判断斜线上是否已经有了皇后，斜线有两种，一种是从左上到右下，即\，还有一种是从右上到左下，即/，对于nxn矩阵来说，斜线的条数是固定的，等于2*n-1，
	     * 所以可以使用两个数据d1[2*n]和d2[2*n]分别表示两种斜线上是否已经有了皇后，接下来的问题就是怎么根据位置计算皇后所在的斜线。
	     * 
	     * 大家可以自己画图推导，我这里就只给出答案了，皇后位置在(row, col)的话，
	     * \: pos = col - row + n
	     * /: pos = col + row
	     * 如果d1[i] = true的话，说明从左上到右下，第i条斜线上以已经有皇后了，如果d2[i] = true的话，则说明从右上到左下这条线上已经有皇后了。
	     * 判断皇后冲突有了后，和解法1一样，使用递归回溯即可解题。
	     */
	    public int solve2(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
	    	if(row == n) {
	    		return 1;
	    	}
	    	int num = 0;
	    	for(int col = 0; col < n; col++) {
	    		int i1 = col - row + n, i2 = col + row;
	    		if(cols[col] || d1[i1] || d2[i2]) {
	    			continue;
	    		}
	    		cols[col] = d1[i1] = d2[i2] = true;
	    		num += solve2(row+1, cols, d1, d2, n);
	    		cols[col] = d1[i1] = d2[i2] = false;
	    	}
	    	return num;
	    }
	    
	}
	
}
