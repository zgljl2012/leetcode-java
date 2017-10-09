package com.ex51_100;

import java.util.Stack;

import org.junit.Test;

import com.base.Base;

public class _84_LargestRectangleInHistogram extends Base {
	
	static class Solution {
		
		/**
		 * @param heights
		 * @return
		 */
	    public int largestRectangleArea(int[] heights) {
	        Stack<Integer> stack = new Stack<>();
	        int maxArea = 0;
	        for(int i=0;i<=heights.length;i++) {
	        		int h = i==heights.length?0:heights[i];
	        		if(stack.empty() || h >= heights[stack.peek()]) {
	        			stack.push(i);
	        		} else {
	        			int top = stack.pop();
	        			maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty()?i:i-1-stack.peek()));
	        			i--;
	        		}
	        }
	        return maxArea;
	    }
	}
	
	@Test
	public void test() {
		Solution s = new Solution();
		int[] heights = {2,1,5,6,2,3};
		println(s.largestRectangleArea(heights));
	}

}
