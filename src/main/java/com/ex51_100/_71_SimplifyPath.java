package com.ex51_100;

import java.util.Stack;

import com.base.Base;

import junit.framework.Assert;

public class _71_SimplifyPath extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Assert.assertEquals("/", s.simplifyPath("/"));
		Assert.assertEquals("/home", s.simplifyPath("/home/"));
		Assert.assertEquals("/a", s.simplifyPath("/a"));
		Assert.assertEquals("/a/b/c", s.simplifyPath("/a/b/c"));
		Assert.assertEquals("/a", s.simplifyPath("/a/"));
		Assert.assertEquals("/a", s.simplifyPath("/./a"));
		Assert.assertEquals("/", s.simplifyPath("/../"));
		Assert.assertEquals("/a", s.simplifyPath("/../a/"));
		Assert.assertEquals("/a/b", s.simplifyPath("/../a/b/"));
		Assert.assertEquals("/c/d", s.simplifyPath("/a/./b/../../c/d/"));
		Assert.assertEquals("/", s.simplifyPath("/home/../../.."));
	}
	
	static public class Solution {
	    public String simplifyPath(String path) {
	    	Stack<String> stack = new Stack<>();
	    	for(String dir:path.split("/")) {
	    		if("..".equals(dir)) {
	    			if(!stack.isEmpty())
	    				stack.pop();
	    		} else if(".".equals(dir)) {
	    			continue;
	    		} else {
	    			if(!"".equals(dir)) {
	    				stack.push(dir);
	    			}
	    		}
	    	}
	    	String r = "";
	    	for(String dir:stack) {
	    		r = r + "/" + dir;
	    	}
	    	return "".equals(r)?"/":r;
	    }
	}

}
