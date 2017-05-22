package com.ex51_100;

import com.base.Base;

import junit.framework.Assert;

public class _60_PermutationSequence extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals("12", s.getPermutation(2, 1));
		Assert.assertEquals("21", s.getPermutation(2, 2));
		Assert.assertEquals("123", s.getPermutation(3, 1));
		Assert.assertEquals("132", s.getPermutation(3, 2));
		Assert.assertEquals("213", s.getPermutation(3, 3));
		Assert.assertEquals("231", s.getPermutation(3, 4));
		Assert.assertEquals("312", s.getPermutation(3, 5));
		Assert.assertEquals("321", s.getPermutation(3, 6));
		Assert.assertEquals("1243", s.getPermutation(4, 2));
	}
	
	static public class Solution {
		
		
		/**
		 * 求第k个顺序的全排列字符串
		 * 因为只要求1个，所以可以按照全排列的规则，一个个数的求出顺序，而不需要将所有的全排列字符串列出来。
		 * 对于n个字符组成的字符串{1,2,3,...,n}，取第k个数时，首先可以求出第一个数，即(k-1)/(n-1个数的排列个数)。
		 * 比如n=3，k=4时，全排列组合为：
		 * 1 + {2,3}的全排列
		 * 2 + {1,3}的全排列
		 * 3 + {1,2}的全排列
		 * 我们可以首先求出目标排序的第一个数字，即(k-1)/(两个数的排列数) = (k-1)/2 = 3/2 = 1，下标从0开始，下标1表示的数就是2.
		 * 接下来，就是求出{1,3}全排列中排在第 k-2=2 个位置上的数，方法同3个字母时一样，求出结果后为 231.
		 * 所以，可以一层一层的求出第k个顺序的字符串。时间复杂度为O(n).
		 * @param n
		 * @param k
		 * @return
		 */
		public String getPermutation(int n, int k) {
			char[] nums = new char[]{'1','2','3','4','5','6','7','8','9'};
	        String tmp = "";
	        for(int i=0;i<n;i++) {
	        	tmp += nums[i];
	        }
	        StringBuffer s = new StringBuffer(tmp);
	        String r = "";
	        while(k>0&&!s.toString().equals("")) {
	        	// 计算 (n-1)的排列个数cnt
	        	int cnt = 1, i = s.length()-1;
		    	while(i > 1) {
		    		cnt*=i;
		    		i-=1;
		    	}
		    	int pos = (k-1)/cnt;
		    	r += s.charAt(pos);
		    	s = s.deleteCharAt(pos);
		    	k -= pos * cnt;
	        }
	        return r;
		}
		
		/**
		 * 求第k个顺序的全排列字符串
		 * 递归版本
		 * @param n
		 * @param k
		 * @return
		 */
	    public String getPermutation1(int n, int k) {
	    	char[] nums = new char[]{'1','2','3','4','5','6','7','8','9'};
	        String s = "";
	        for(int i=0;i<n;i++) {
	        	s += nums[i];
	        }
	        return fun(new StringBuffer(s), k);
	    }
	    
	    public String fun(StringBuffer s, int k) {
	    	if(k<0 || s.toString().equals("")) return "";
	    	int cnt = 1, tmp = s.length()-1;
	    	while(tmp > 1) {
	    		cnt*=tmp;
	    		tmp-=1;
	    	}
	    	int pos = (k-1)/cnt;
	    	return s.charAt(pos) + fun(s.deleteCharAt(pos), k - pos*cnt);
	    }
	}
	
}
