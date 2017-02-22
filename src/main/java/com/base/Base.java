package com.base;

import java.util.ArrayList;
import java.util.List;

public class Base {
	
	public static void print(Object o) {
		System.out.print(o);
	}
	
	public static void println(Object o) {
		System.out.println(o);
	}
	
	public static void println(ListNode p) {
		while(p!=null) {
			print(p.val+" ");
			p = p.next;
		}
		println("");
	}
	
	public static List<Integer> toArrays(int[] arr) {
		List<Integer> list = new ArrayList<>(arr.length);
		for(int i=0;i<arr.length;i++) {
			list.set(i, arr[i]);
		}
		return list;
	}
	
	/**
	 * 将数组转化为链表
	 * @param arr
	 * @return
	 */
	public static ListNode toListNode(int[] arr) {
		if(arr==null||arr.length==0) return null;
		ListNode r = new ListNode(arr[0]);
		ListNode p = r;
		for(int i=1;i<arr.length;i++) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		return r;
	}
	
	/**
	 * 树节点
	 * @author zgljl2012
	 *
	 */
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }
	}
	
	/**
	 * 链表节点
	 * @author zgljl2012
	 */
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	
}
