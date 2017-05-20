package com.ex51_100;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _57_InsertInterval extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] nums = {{1,5}};
		println(s.insert(fun(nums), new Interval(5,7)));
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
		 * 将一个interval插入到已经排序好了的intervals中
		 * 因为已经排序好了，所以只需要一个个遍历比较看是否需要合并，然后将其添加到结果数组中即可。
		 * 遍历时，设当前interval为it，会发生以下三种情况：
		 * 1. newInterval在it前面，表现为newInterval.end < it.start，此时先添加newInterval，后添加it，因为newInterval已经添加进去了，所以后面的就无需比较了
		 * 2. newInterval在it后面，表现为newInterval.start > it.end，此时只添加it到结果数组中即可，让newInterval再与后面的去比较
		 * 3. 两者有重叠部分，需要合并，将it合并到newInterval中 
		 * @param intervals
		 * @param newInterval
		 * @return
		 */
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new ArrayList<>();
	        boolean hasInserted = false; // 是否已插入newInterval
	        for(Interval it:intervals) {
	        	if(hasInserted || it.end < newInterval.start) {
	        		res.add(it);
	        	} else if(it.start > newInterval.end) {
	        		res.add(newInterval);
	        		res.add(it);
	        		hasInserted = true;
	        	} else {
	        		newInterval.start = Math.min(newInterval.start, it.start);
	        		newInterval.end = Math.max(newInterval.end, it.end);
	        	}
	        }
	        if(!hasInserted) {
	        	res.add(newInterval);
	        }
	        return res;
	    }
	}
	
}
