package com.ex1_50;

import com.base.Base;

public class _25_ReverseNodesinkGroup extends Base {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11};
		Solution s = new Solution();
		println(s.reverse(Base.toListNode(nums), 3));
		println(s.reverseKGroup(Base.toListNode(nums), 3));
	}
	
	static public class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        int len = 0;
	        ListNode p = head;
	        while(p!=null) {
	        	len++;
	        	p = p.next;
	        }
	        if(len == 0) {
	        	return head;
	        }
	        p = head;
	        ListNode q = null;
	        for(int i=0;i<len;i++) {
	        	if((i+1)%k==0) {
	        		p = reverse(p, k);
	        		if(q==null) {
	        			q = p;
	        			head = q;
	        		} else {
	        			q.next = p;
	        		}
	        		int cnt = 0;
	        		while(p!=null&&cnt<k-1) {
	        			cnt++;
	        			p=p.next;
	        		}
	        		q = p;
	        		p = p.next;
	        	}
	        }
	        return head;
	    }
	    
	    public ListNode reverse(ListNode p, int k) {
	    	if(p==null) return p;
	    	ListNode q = p, head = p;
	    	p = p.next;
	    	while(p!=null&&k>1) {
	    		q.next = p.next;
	    		p.next = head;
	    		head = p;
	    		p = q.next;
	    		k--;
	    	}
	    	return head;
	    }
	}
}
