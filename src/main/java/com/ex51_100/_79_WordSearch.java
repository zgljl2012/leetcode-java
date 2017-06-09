package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _79_WordSearch extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		Assert.assertEquals(true, s.exist(board, "ABCCED"));
		Assert.assertEquals(true, s.exist(board, "SEE"));
		Assert.assertEquals(false, s.exist(board, "ABCB"));
	}
	
	static public class Solution {
	    public boolean exist(char[][] board, String word) {
	    	if(board == null || board.length == 0) {
	    		return false;
	    	}
	    	boolean[][] visited = new boolean[board.length][board[0].length];
	    	boolean exist = false;
	    	for(int i=0;i<board.length;i++) {
	    		for(int j=0;j<board[i].length;j++) {
	    			exist = exist(board, visited, word, 0, i, j);
	    			if(exist) {
	    				return true;
	    			}
	    		}
	    	}
	        return exist;
	    }
	    
	    /**
	     * 回溯算法进行搜索
	     * @param board 字符表
	     * @param visited 该字符是否已被访问
	     * @param word 字符串
	     * @param cur 当前字符,前面的0-(cur-1)已全部匹配，从(i,j)开始搜索
	     * @param i 字符表的开始点行
	     * @param j 字符表的开始点列
	     * @return
	     */
	    private boolean exist(char[][] board, boolean[][] visited, String word, int cur, int i, int j) {
	    	if(cur == word.length()) {
	    		return true;
	    	}
	    	if(i<0||i>=board.length || j<0 || j >= board[0].length || visited[i][j]) {
	    		return false;
	    	}
	    	if(word.charAt(cur) != board[i][j]) {
	    		return false;
	    	}
	    	visited[i][j] = true;
	    	boolean b = exist(board, visited, word, cur+1, i+1, j) 
	    			|| exist(board, visited, word, cur+1, i, j+1)
	    			|| exist(board, visited, word, cur+1, i-1, j)
	    			|| exist(board, visited, word, cur+1, i, j-1);
	    	visited[i][j] = false;
	    	return b;
	    }
	}
	
}
