package com.ex451_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.base.Base;

public class _500_KeyboardRow extends Base{

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] ss = s.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
		for(String t:ss) {
			println(t);
		}
	}

static public class Solution {
    public String[] findWords(String[] words) {
    	char[] l1 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    	char[] l2 = {'A', 'S', 'D','F', 'G', 'H', 'J', 'K', 'L'};
    	char[] l3 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        Set<Character> line1 = new HashSet<>();
        for(int i=0;i<l1.length;i++) {
        	line1.add(l1[i]);
        }
        Set<Character> line2 = new HashSet<>();
        for(int i=0;i<l2.length;i++) {
        	line2.add(l2[i]);
        }
        Set<Character> line3 = new HashSet<>();
        for(int i=0;i<l3.length;i++) {
        	line3.add(l3[i]);
        }
        
        List<String> r = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
        	String tmp = words[i].toUpperCase();
        	boolean b1 = true, b2 = true, b3 = true;
        	for(Character ch:tmp.toCharArray()) {
        		if(b1&&!line1.contains(ch)) {
        			b1 = false; 
        		}
        		if(b2&&!line2.contains(ch)) {
        			b2 = false; 
        		}
        		if(b3&&!line3.contains(ch)) {
        			b3 = false; 
        		}
        	}
        	if(b1||b2||b3) {
        		r.add(words[i]);
        	}
        }
        String[] arr = new String[r.size()];
        return r.toArray(arr);
    }
}
	
}
