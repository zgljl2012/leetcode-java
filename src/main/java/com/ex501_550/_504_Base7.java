package com.ex501_550;

import com.base.Base;

public class _504_Base7 extends Base {

	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.convertToBase7(-10));
		println(s.convertToBase7(-7));
		println(s.convertToBase7(100));
	}
	
static public class Solution {
    public String convertToBase7(int num) {
    	if(num==0) return "0";
        String r = "";
        boolean b = num<0;
        num = Math.abs(num);
        while(num>0) {
        	r = num%7 + r;
        	num/=7;
        }
        return b?"-"+r:r;
    }
}

}
