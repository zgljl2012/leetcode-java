package com.ex1_50;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;


public class _22_GenerateParentheses extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.generateParenthesis(3));
	}
	
	static public class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<>();
	        this.parenthesis(res, "", n, 0, 0);
	        return res;
	    }
	    
	    public void parenthesis(List<String> res, String s, int n, int left, int right) {
	    	if(s.length()==2*n) {
	    		res.add(s);
	    		return;
	    	}
	    	if(left<n) {
	    		parenthesis(res, s+"(", n, left+1, right);
	    	}
	    	if(right<left) {
	    		parenthesis(res, s+")", n, left, right+1);
	    	}
	    }
	}
	
}
