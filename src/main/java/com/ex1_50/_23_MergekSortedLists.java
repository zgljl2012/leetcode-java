package com.ex1_50;

import java.util.PriorityQueue;

import com.base.Base;

public class _23_MergekSortedLists extends Base {
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10};
		int[] arr3 = {-1,0,2,5,6,9,10};
		ListNode[] lists = {toListNode(arr1),toListNode(arr2),toListNode(arr3)};
		Solution s = new Solution();
		println(s.mergeKLists(lists));
		
	}
	
	static public class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	        if(lists==null||lists.length==0) return null;
	        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, 
	        		(a,b)->Integer.compare(a.val, b.val));
	        ListNode head = new ListNode(0);
	        ListNode tail = head;
	        for(ListNode n:lists) {
	        	if(n!=null) {
	        		queue.add(n);
	        	}
	        }
	        while(!queue.isEmpty()) {
	        	tail.next = queue.poll();
	        	tail = tail.next;
	        	if(tail.next!=null) {
	        		queue.add(tail.next);
	        	}
	        }
	        return head.next;
	    }
	}
}
