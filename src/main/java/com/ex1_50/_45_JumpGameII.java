package com.ex1_50;

import com.base.Base;

public class _45_JumpGameII extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2,3,1,1,4};
		println(s.jump(nums));
	}
	
	static public class Solution {
		
		/**
		 * Solutions中看到的最优雅的算法，每次遍历都先记录当前能跳到的最大位置，如果已经到了上一个最大位置，则说明又得跳一次，否则就不用跳
		 * @param nums
		 * @return
		 */
	    public int jump(int[] nums) {
	    	int steps = 0; // 步数
	    	int last_jump_max = 0; // 上一个能跳到的最大位置，到了这一位置，就说明要再跳一步
	    	int current_jump_max = 0; // 当前能跳到的最大位置
	    	for(int i=0;i < nums.length - 1;i++) {
	    		current_jump_max = Math.max(current_jump_max, i + nums[i]);
	    		if(i == last_jump_max) {
	    			steps++;
	    			last_jump_max = current_jump_max;
	    		}
	    	}
	    	return steps;
	    }
	}

}
