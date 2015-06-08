public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {

		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		// prev.next = head;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			// cur.next = null;
			while (prev.next != null && cur.val > prev.next.val)
				prev = prev.next;
			cur.next = prev.next;
			prev.next = cur;
			prev = dummy;
			cur = next;
		}

		return dummy.next;
	}


}