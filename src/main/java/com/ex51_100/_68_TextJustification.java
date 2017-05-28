package com.ex51_100;

import java.util.ArrayList;
import java.util.List;

import com.base.Base;

public class _68_TextJustification extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
	}
	
	static public class Solution {
		
		/**
		 * 文本显示调整问题，将一系列单词words[n]按行显示，每一行做多只能有L个字母，如：
		 * words=["This", "is", "an", "example", "of", "text", "justification."]，L=16
		 * 最终显示的行为：["This    is    an", "example  of text", "justification.  "]
		 * 输出的行需要满足几个条件
		 * 1. 每一行的单词要尽可能的多，并且要左右都能顶格，不足L个字符时，可以使用空格' '代替字母
		 * 2. 每一行单词之间的空格要尽可能地均匀，不能满足均匀的前提下，左边的要比右边的多
		 * 3. 最后一行只要满足左边顶格，并且单词之间不要有多余空格
		 * 
		 * 算法：
		 * 遍历到一个单词时，往前探到几个单词符合要求，即单词的字母数之和加上单词之间的空格要小于等于L，探到符合要求的单词数后就开始组织行。
		 * 因为单词已经有了，接下来就是安排好单词的位置了，有n个单词，那么就会有n-1个间隔，那么除了最后一行外的每个间隔的空格数应该是：(L-n个单词的字母总量)/(n-1)，
		 * 但因为有时不能除尽，最后一个间隔有可能会少，要进行判断。最后一行按照普通的做法，从左到右排好单词即可。
		 * 参考自：https://discuss.leetcode.com/topic/9147/simple-java-solution
		 */
	    public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> lines = new ArrayList<>();
	        int cur = 0;
	        while(cur < words.length) {
	        	int last = cur+1;
	        	int cnt = words[cur].length(); // 单词的字母数
	        	while(last < words.length) {
	        		if(words[last].length() + cnt + 1 > maxWidth) {
	        			break;
	        		}
	        		cnt += words[last].length()+1;
	        		last++;
	        	}
	        	int gap = last - cur - 1;
	        	StringBuilder sb = new StringBuilder();
	        	if(last == words.length || gap == 0) { // 到了最后一行或者只有一个单词
	        		for(int i=cur;i<last;i++) {
	        			sb.append(words[i]+" ");
	        		}
	        		sb.deleteCharAt(sb.length()-1);
	        		for(int i=sb.length();i<maxWidth;i++) {
	        			sb.append(" ");
	        		}
	        	} else {
	        		int spaces = (maxWidth - cnt) / gap;
	        		int rem = (maxWidth - cnt) % gap;
	        		for(int i=cur;i<last;i++) {
	        			sb.append(words[i]);
	        			if(i<last-1) {
	        				for(int j=0;j<=(spaces+(i-cur<rem?1:0));j++) {
	        					sb.append(" ");
	        				}
	        			}
	        		}
	        	}
	        	lines.add(sb.toString());
	        	cur = last;
	        }
	        return lines;
	    }
	}

}
