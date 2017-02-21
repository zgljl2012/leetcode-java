package com.ex401_450;

import com.base.Base;

public class _434_NumberOfSegmentsInAString extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		println(s.countSegments("Hello"));
		println(s.countSegments("Hello, this is a pig"));
	}
	
	static public class Solution {
	    public int countSegments(String s) {
	        int cnt = 0;
	        boolean b = true;
	        for(int i=0;i<s.length();i++) {
	        	if(s.charAt(i)!=' ') {
	        		if(b) {
	        			cnt++;
	        		}
	        		b = false;
	        	} else {
	        		b = true;
	        	}
	        }
	        return cnt;
	    }
	}

}
