package com.ex501_550;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.base.Base;

public class _506_RelativeRanks extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr = s.findRelativeRanks(new int[]{5, 4, 6, 3, 2, 1});
		for(String t:arr) {
			println(t);
		}
	}

static public class Solution {
    public String[] findRelativeRanks(int[] nums) {
    	if(nums==null||nums.length==0) return new String[]{};
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        Map<Integer, String> map = new HashMap<>();
        int i = nums.length-1;
        map.put(nums2[i--], "Gold Medal");
        if(nums2.length>1)
        	map.put(nums2[i--], "Silver Medal");
        if(nums2.length>2)
        	map.put(nums2[i--], "Bronze Medal");
        for(int j = 4; i >= 0; i--,j++) {
        	map.put(nums2[i], "" + j);
        }
        String[] r = new String[nums.length];
        for(i=0;i<r.length;i++) {
        	r[i] = map.get(nums[i]);
        }
        return r;
    }
}

}
