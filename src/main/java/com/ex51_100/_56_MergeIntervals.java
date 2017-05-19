package com.ex51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.base.Base;

public class _56_MergeIntervals extends Base {
	
	public static void main(String[] args) {
		int[][] nums = {{1,4},{2,5}};
		Solution s = new Solution();
		println(s.merge(fun(nums)));
	}
	
	static public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
	
	static List<Interval> fun(int[][] nums) {
		List<Interval> r = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			r.add(new Interval(nums[i][0], nums[i][1]));
		}
		return r;
	}
	
	static public class Solution {
	    
		/**
		 * 首先根据每个Interval的start排序，然后遍历去比较end即可
		 */
		public List<Interval> merge(List<Interval> intervals) {
	    	List<Interval> res = new ArrayList<>();
	    	if(intervals == null || intervals.isEmpty()) return res;
	    	Collections.sort(intervals, new Comparator<Interval>(){

				@Override
				public int compare(Interval a, Interval b) {
					if(a.start < b.start) {
						return -1;
					} else if(a.start > b.start) {
						return 1;
					}
					return 0;
				}
	    	});
	    	int start=intervals.get(0).start, end=intervals.get(0).end;
	    	for(Interval it:intervals) {
	    		if(it.start <= end) {
	    			end = Math.max(it.end, end);
	    		} else {
	    			res.add(new Interval(start, end));
	    			start = it.start;
	    			end = it.end;
	    		}
	    	}
	    	res.add(new Interval(start, end));
	    	return res;
	    }
	}
	
}
