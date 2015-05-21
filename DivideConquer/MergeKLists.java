import java.util.*;

public class MergeKLists {
	/*
	 * 3 methods: 
	 *  1. merge sort, time: O(nklogk), space: O(logk)
	 *  2. non-recursive merge sort, space: O(1)
	 *  3. heap, time: O(nklogk), space: O(logk)
	 */

	public ListNode bruteForce(ListNode[] lists) {
		if (lists.length == 0) return null;
		ListNode res = lists[0];
		for (int i=1; i<lists.length; i++) {
			res = merge(res, lists[i]);
		}
		return res;
	}

	public ListNode recursiveMerge(ListNode[] lists) {
		return mergeHelper(lists, 0, lists.length-1);
	}

	public ListNode nonRecursiveMerge(ListNode[] lists) {
		int n = lists.length;
		while (n > 1) {
			int len = (n+1) / 2;
			for (int i=0; i+len<lists.length; i++) {
				lists[i] = merge(lists[i], lists[i+len]);
			}
			n = len;
		}
		return n == 0 ? null : lists[0];
	}

	public ListNode heapSolution(ListNode[] lists) {
		if (lists.length == 0) return null; // PriorityQueue constructor can't be 0
		PriorityQueue<ListNode> heap = new PriorityQueue(lists.length, new Comparator<ListNode>(){
			public int compare (ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		for (int i=0; i<lists.length; i++) {
			if (lists[i] == null) continue;
			heap.offer(lists[i]);
			lists[i] = lists[i].next;
		}

		ListNode dummy = new ListNode(0);
		ListNode tmp = dummy;

		while (heap.size() > 0) {
			ListNode node = heap.poll();
			tmp.next = node;
			tmp = tmp.next;
			if (node.next != null) heap.offer(node.next);
		}

		return dummy.next;
	}


	//helper methods
	public ListNode mergeHelper(ListNode[] lists, int start, int end) {

		if (start > end) return null;
		if (start == end) return lists[start];

		int mid = start + (end - start) / 2;
		return merge(mergeHelper(lists, start, mid), mergeHelper(lists, mid+1, end));

	}


	public ListNode merge(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode tmp = dummy;

		while (l1!=null && l2!=null) {

			if (l1 < l2) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}

		while (l1 != null) {
			tmp.next = l1;
			tmp = tmp.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			tmp.next = l2;
			tmp = tmp.next;
			l2 = l2.next;
		}

		return dummy.next;
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */