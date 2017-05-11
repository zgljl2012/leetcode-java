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
	
	public static void println(int[] arr) {
		for(Integer i:arr) {
			print(i+" ");
		}
		println("");
	}
	
	public static void println(Object[] arr) {
		for(Object i:arr) {
			print(i+" ");
		}
		println("");
	}
	
	public static void println(int[][] arrs) {
		for(int[] arr:arrs) {
			for(int a:arr) {
				print(a+" ");
			}
			println("");
		}
	}
	
	public static void println(char[][] arrs) {
		for(char[] arr:arrs) {
			for(char a:arr) {
				print(a+" ");
			}
			println("");
		}
	}
	
	public static List<Integer> toArrays(int[] arr) {
		List<Integer> list = new ArrayList<>(arr.length);
		for(int i=0;i<arr.length;i++) {
			list.set(i, arr[i]);
		}
		return list;
	}
	
	/**
	 * 灏嗘暟缁勮浆鍖栦负閾捐〃
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
	 * 鏍戣妭鐐�
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
	 * 閾捐〃鑺傜偣
	 * @author zgljl2012
	 */
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	
}
