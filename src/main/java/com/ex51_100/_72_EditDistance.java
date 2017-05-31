package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _72_EditDistance extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals(5, s.minDistance("", "Hello"));
		Assert.assertEquals(5, s.minDistance("W", "Hello"));
		Assert.assertEquals(4, s.minDistance("H", "Hello"));
		Assert.assertEquals(3, s.minDistance("He", "Hello"));
		Assert.assertEquals(3, s.minDistance("Ho", "Hello"));
	}
	
	static public class Solution {
		
		/**
		 * 将word1变为word2，可以有三种操作，删除、替换、增加一个字符，每执行一次算作一次操作，返回至少需要多少次操作。
		 * 算法：
		 * 使用动态规划，设f(i,j)表示将word1的前i个字符转化为word2的前j个字符，设n=word1.length(), m=word2.length()，则最终的结果就是求：f(n, m)
		 * 下面是动态转移方程：
		 * 1. 初始条件，f(0,k) = f(k,0) = k，f(0,k)=k表示将word1的前0个字符转换为word2的前k个字符所需操作数，因为是从0个字符变换为k个字符，自然需要k次操作
		 * 2. word1[i] = word2[j]时，有f(i,j) = f(i-1,j-1)，因为此时不需要操作，所以操作次数与前面的变换次数相等
		 * 3. word2[i] != word2[j]时，有f(i,j) = 1 + min{f(i,j-1), f(i-1,j), f(i-1,j-1)}，f(i,j-1)表示insert, f(i-1,j)表示delete，f(i-1,j-1)表示replace
		 */
	    public int minDistance(String word1, String word2) {
	        int n = word1.length();
	        int m = word2.length();
	        
	        int[][] f = new int[n+1][m+1];
	        for(int i=0;i<=m;i++) {
	        	f[0][i] = i;
	        }
	        for(int i=0;i<=n;i++) {
	        	f[i][0] = i;
	        }
	        for(int i=1;i<=n;i++) {
	        	for(int j=1;j<=m;j++) {
	        		if(word1.charAt(i-1) == word2.charAt(j-1)) {
	        			f[i][j] = f[i-1][j-1];
	        		} else {
	        			f[i][j] = 1 + Math.min(f[i][j-1], Math.min(f[i-1][j], f[i-1][j-1]));
	        		}
	        	}
	        }
	        return f[n][m];
	    }
	}
	
}
