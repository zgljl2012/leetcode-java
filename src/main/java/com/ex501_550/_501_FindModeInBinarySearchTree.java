package com.ex501_550;

import com.base.Base;

public class _501_FindModeInBinarySearchTree extends Base {

	public static void main(String[] args) {
		
	}

static public class Solution {
	private int max = 0;  
    private int currval = 0;  
    private int currcount = 0;  
    private int currmodes = 0;  
    private int[] modes;  
      
    public int[] findMode(TreeNode root) {  
        helper(root);  
        modes = new int[currmodes];  
        currcount = 0;  
        currmodes = 0;  
        helper(root);  
        return modes;  
    }  
      
    public void helper(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        helper(root.left);  
        if (root.val != currval) {  
            currval = root.val;  
            currcount = 1;  
        } else {  
            currcount ++;  
        }  
        if (currcount > max) {  
            max = currcount;  
            currmodes = 1;  
        }else if (currcount == max) {  
            if (modes != null) {  
                modes[currmodes] = root.val;  
            }  
            currmodes ++;  
        }  
        helper(root.right);  
    }  
}	
	
}
