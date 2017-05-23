package com.ex51_100;

import com.base.Base;

public class _61_RotateList extends Base {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		println(s.rotateRight(Base.toListNode(new int[]{1,2,3,4,5}), 5));
	}
	
	static public class Solution {
	    public ListNode rotateRight(ListNode head, int k) {
	    	if(head == null || k<=0) return head;
	        // 链表计数
	        int cnt = 0;
	        ListNode p = head, q = head;
	        while(p!=null) {
	        	p = p.next;
	        	cnt++;
	        }
	        if(k % cnt == 0) return head;
	        k = k % cnt;
	        k = cnt - k;
	        p = head;
	        while(k-->0 && p.next != null) {
	        	q = p;
	        	p = p.next;
	        }
	        q.next = null;
	        q = p;
	        while(q.next!=null) {
	        	q = q.next;
	        }
	        if(q!=head)
	        	q.next = head;
	        return p;
	    }
	}

}
