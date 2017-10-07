package com.ex51_100;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.base.Base;

public class _82_RemoveDuplicatesFromSortedListII extends Base {

	/*
	 * 算法：
	 * 使用栈，依次将链表推入栈中，如果当前元素与栈顶元素一致，则使用一个变量记录需要pop当前栈顶元素；若不一致，先检验是否需要pop栈顶元素，然后再与（新）栈顶元素比对是否一致，
	 * 若不一致，推入栈中。最后遍历栈中的元素，依次建立新链表。
	 */
	static class Solution1 {
	    public ListNode deleteDuplicates(ListNode head) {
	        Stack<ListNode> stack = new Stack<>();
	        ListNode p = head;
	        boolean need_pop = false;
	        while(p!=null) {
	        		if(stack.empty()) {
	        			stack.push(p);
	        			p = p.next;
	        			continue;
	        		}
	        		if(stack.peek().val != p.val && need_pop) {
	        			stack.pop();
	        			need_pop = false;
	        		}
	        		if(!stack.empty() && stack.peek().val != p.val) {
	        			stack.push(p);
	        		} else if(!stack.empty()){
	        			need_pop = true;
	        		} else {
	        			stack.push(p);
	        		}
	        		p=p.next;
	        }
	        if(need_pop) {
	        		stack.pop();
	        }
	        if(stack.empty()) return null;
	        head = stack.firstElement();
	        p = head;
	        ListNode[] list = stack.toArray(new ListNode[stack.size()]);
	        for(int i=1;i<stack.size();i++) {
	        		p.next = list[i];
	        		p = p.next;
	        }
	        p.next = null;
	        return head;
	    }
	}
	
	/**
	 * 上面那个算法速度太慢了。因为当时看错题了，以为是不排序的数组。既然数组是排好序了的，那么直接遍历即可。
	 */
	static class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	    		ListNode newHead = new ListNode(0);
	    		ListNode newTail = null;
	    		ListNode q = null;
	    		ListNode p = head;
	    		boolean hasDup = false;
	    		while(p!=null) {
	    			if(newHead.next == null) {
	    				newHead.next = newTail = p;
	    				q = newHead;
	    			} else {
	    				if(p.val != newTail.val) {
	    					if(hasDup) {
	    						newTail = q;
	    					}
	    					newTail.next = p;
	    					q = newTail;
	    					newTail = p;
	    					hasDup = false;
	    				} else {
	    					hasDup = true;
	    				}
	    			}
	    			p = p.next;
	    		}
	    		if(hasDup) {
	    			q.next = null;
	    		}
	    		return newHead.next;
	    }
	}
	
	Solution s;
	
	@Before
	public void init() {
		s = new Solution();
	}
	
	@Test
	public void test1() {
		int[] arr = new int[] {1,1,2,2,2,3,3,4,4,5,5,6,6,6,7,7};
		ListNode head = new ListNode(arr[0]);
		ListNode p = head;
		for(int i=1;i<arr.length;i++) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		head = s.deleteDuplicates(head);
		println(head);
	}
	
	
}
