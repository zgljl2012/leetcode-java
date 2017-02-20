package com.easy;

import com.base.Base;

public class _437_Path_Sum_III extends Base {
	
	
	static public class Solution {
	    public int pathSum(TreeNode root, int sum) {
	    	if(root==null) return 0;
	    	return helper(root, sum) + pathSum(root.left, sum-root.val) + pathSum(root.right, sum-root.val);
	    }
	    
	    public int helper(TreeNode p, int sum) {
	    	if(p==null) return 0;
	    	int cnt = 0;
	    	if(p.val == sum) {
	    		cnt++;
	    	}
	    	return cnt+helper(p.left, sum-p.val)+helper(p.right, sum-p.val);
	    }
	}

}
