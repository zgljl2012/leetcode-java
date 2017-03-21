package com.ex1_50;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

/**
 * url: https://leetcode.com/problems/sudoku-solver/?tab=Description
 * @author zgljl2012
 *
 */
public class _37_SudokuSolver extends Base {
	
	public static void main(String[] args) {
		// 初始完成版数独
		String[] strs = null;//new String[]{"534678912","672195348", "198342567", "859761423", "426853791", "713924856", "961537284", "287419635", "345286179"};
		Solution solution = new Solution();
		strs = new String[]{"53..7....","6..195...", ".98....6.", "8...6...3", 
				"4..8.3..1", "7...2...6", "961537284", "287419635", "34528617."};
		char[][] board = toCharArr(strs);
		solution.solveSudoku(board);
		println(board);
	}
	
	public static char[][] toCharArr(String[] strs) {
		List<char[]> arr = new ArrayList<>();
		for(String s:strs) {
			arr.add(s.toCharArray());
		}
		return arr.toArray(new char[strs.length][strs[0].length()]);
	}
	
	static public class Solution {
		public void solveSudoku(char[][] board) {
	    	
	    }
	}
	
	/**
	 * 普通方法
	 * 直接一个个试
	 * @author {author name}
	 *
	 */
	static public class Solution_normal {
		
		/**
		 * 判断target是否在一个九宫格中出现过
		 * @param x
		 * @param y
		 * @param target
		 * @param board
		 * @return
		 */
		boolean isInBlock(int x, int y, char target, char[][] board) {
			x = x/3;
			y = y/3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(board[x*3+i][y*3+j] == target) {
						return true;
					}
				}
			}
			return false;
		}
		
		/**
		 * 判断target是否在一行中出现过
		 * @param i
		 * @param target
		 * @param board
		 * @return
		 */
		boolean isInRow(int i, char target, char[][] board) {
			for(int j=0;j<9;j++) {
				if(board[i][j]==target) {
					return true;
				}
			}
			return false;
		}
		
		/**
		 * 判断target是否在一列中出现过
		 * @param j
		 * @param target
		 * @param board
		 * @return
		 */
		boolean isInCol(int j, char target, char[][] board) {
			for(int i=0;i<9;i++) {
				if(board[i][j]==target) {
					return true;
				}
			}
			return false;
		}
		
		/**
		 * 递归填数字
		 * @param board
		 * @return
		 */
		public boolean sodoku(char[][] board) {
			// 找到第一个要填的位置
			int col = -1, row = -1;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(board[i][j]=='.') {
						row = i;
						col = j;
						break;
					}
				}
				if(col!=-1) break;
			}
			if(col==-1) {
				return true;
			}
			char[][] board2 = new char[9][9];
			copy(board, board2);
			for(char i='1';i<='9';i++) {
				if(isInBlock(row, col, i, board) || isInRow(row, i, board) || 
						isInCol(col, i, board)) { 
					continue;
				}
				board[row][col] = i;
				boolean isFull = sodoku(board);
				if(isFull) {
					return true;
				}
				copy(board2, board);
			}
			return false;
		}
		
		public void copy(char[][] from, char[][] to) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					to[i][j] = from[i][j];
				}
			}
		}
		
	    public void solveSudoku(char[][] board) {
	    	sodoku(board);
	    }
	}
	
}
