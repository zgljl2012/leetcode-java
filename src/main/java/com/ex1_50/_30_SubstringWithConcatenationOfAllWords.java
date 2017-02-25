package com.ex1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.Base;

public class _30_SubstringWithConcatenationOfAllWords extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
//		println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0,9]
//		println(s.findSubstring("barthefoobarman", new String[]{"foo", "bar"})); // [6]
//		println(s.findSubstring("barfoo", new String[]{"foo", "bar"})); // [0]
//		println(s.findSubstring("bar", new String[]{"foo", "bar"})); // []
//		//[6,9,12]
		println(s.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));
		println(s.findSubstring("foobarfoobar", new String[]{"foo", "bar"})); // [0,3,6]
		println(s.findSubstring("foobarfoobar", new String[]{"foo", "bar", "bar"})); // [3]
		println(s.findSubstring("aaa", new String[]{"aa","aa"}));// [0,1]
		// [8]
		println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
		
	}
	
	static public class Solution {
	    public List<Integer> findSubstring(String s, String[] words) {
	        List<Integer> r = new ArrayList<>();
	        if(s==null||words==null||words.length==0)
	        	return r;
	        Map<String, Integer> mapCnt = new HashMap<>();
	        for(String tmp:words) {
	        	mapCnt.put(tmp, mapCnt.getOrDefault(tmp, 0)+1);
	        }
	        
	        int len = words[0].length();
	        
	        for(int i=0;i<=s.length()-len*words.length;i++) {
	        	Map<String, Integer> map = new HashMap<>(mapCnt);
	        	for(int j=0;j<words.length;j++) {
	        		String str = s.substring(i+j*len, i+j*len+len);
	        		if(map.containsKey(str)) {
	        			int cnt = map.get(str);
	        			if(cnt == 1) map.remove(str);
	        			else {
	        				map.put(str, cnt-1);
	        			}
	        			if(map.isEmpty()) {
	        				r.add(i);
	        				break;
	        			}
	        		} else {
	        			break;
	        		}
	        	}
	        }
	        return r;
	    }
	}
}
