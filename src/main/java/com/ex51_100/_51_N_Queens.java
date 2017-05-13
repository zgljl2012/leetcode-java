package com.ex51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.base.Base;

public class _51_N_Queens extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.solveNQueens(4));
	}
	
	static public class Solution {
		
		/**
		 * N-皇后问题
		 * 因为国际象棋中，皇后可以在横、竖、斜线上不限步数地吃掉其他棋子，所以N个皇后不能在同一行、同一列以及同一斜线上。
		 * 考虑n个皇后的放法时，我们先按照简单暴力算法的思路来捋一捋题目。
		 * 我们首先一个一个位置试探，比如先在(1,1)，即第一行、第一列上放置第一个皇后，，然后在(1,2)放置第二个皇后，这时候，就看皇后们是不是在同行、同列或同斜线，
		 * 皇后不能在同一行，所以第二个皇后放(1,2)就不行，同时第二个皇后放第一行都不可行，所以我们就可以直接考虑第二行了，根据不能同行这个特点，我们在遍历解法时，
		 * 就可以直接排除掉“行”这个因素了。这时候，一个解法就可以实现使用一个数组c[n]表示，c[i]=j，表示第i行的皇后放在第j列。
		 * 
		 * 接下来，考虑根据c[n]如何判断皇后是同列或同斜线的。
		 * 
		 * 同列容易，如果c[i]=c[j]，就表明两个皇后在同一列，解法不可取；同斜即当i-j = c[i]-c[j]时，第i行的皇后和第j行的皇后同斜线，即行之间的差等于列之间的差时，两个皇后同斜线。
		 * 
		 * 考虑好了一个解法怎么出来后，就只需要使用递归回溯就可以得出所有解法了。
		 * @param n
		 * @return
		 */
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<>();
	        solve(res, new int[n], n, 0, new String[n]);
	        return res;
	    }
	    
	    public void solve(List<List<String>> list, int[] c, int n, int index, String[] cur) {
	    	if(index == n) {
	    		list.add(Arrays.asList(cur.clone()));
	    		return;
	    	}
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
	    			char[] row = new char[n];
		    		Arrays.fill(row, '.');
		    		row[j] = 'Q';
		    		cur[index] = new String(row);
	    			// 如果没有冲突，当前解法可行，增加一位皇后
	    			solve(list, c, n, index+1, cur);
	    		}
	    	}
	    }
	}

}
