package com.ex1_50;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _46_Permutations extends Base {
	
	public static void main(String[] args) {
		int n[] = {1,2,3};
		Solution s = new Solution();
		println(s.permute(n));
	}
	
	
	static public class Solution {
		/**
		 * 一个个的将每一个数插入数组，如数组[1,2,3]，设结果二重数组为r，初始化r中只有一个数组
		 * r=[[1]]，然后要插入数据2，有两种插法，[1,2]和[2,1]，即插在1前面和后面，从而r里有了两个数组
		 * r=[[1,2],[2,1]]，接下来插入数据3,对于数组[1,2]，3可以插在位置{0,1,2},得到三个数组
		 * [3,1,2]和[1,3,2]和[1,2,3]，对于数组[2,1]同样会有三个数组，从而r中会有6个数组：
		 * r=[[3,1,2],[1,3,2],[1,2,3],[3,2,1],[2,3,1],[2,1,3]]，就得到了所需结果。
		 * @param nums
		 * @return
		 */
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> r = new ArrayList<>();
	        if(nums.length == 0) return r;
	        List<Integer> arr = new ArrayList<>();
	        arr.add(nums[0]);
	        r.add(arr);
	        for(int i=1;i<nums.length;i++) {
	        	List<List<Integer>> new_r = new ArrayList<>();
	        	for(List<Integer> l:r) {
	        		for(int j=0;j<=i;j++) {
	        			List<Integer> tmp = new ArrayList<>(l);
	        			tmp.add(j, nums[i]);
	        			new_r.add(tmp);
	        		}
	        	}
	        	r = new_r;
	        }
	        return r;
	    }
	}

}
