public class SortList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) return head;

		ListNode right = split(head);
		return merge(sortList(head), sortList(right));

	}

	public ListNode split(ListNode node) {

		ListNode runner = node;
		while (runner != null && runner.next != null && runner.next.next != null) {
			runner = runner.next.next;
			node = node.next;
		}
		ListNode tmp = node.next;
		node.next = null;
		return tmp;

	}

	public ListNode merge(ListNode n1, ListNode n2) {

		ListNode dummy = new ListNode(0);
		ListNode tmp = dummy;

		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				tmp.next = n1;
				n1 = n1.next;
			} else {
				tmp.next = n2;
				n2 = n2.next;
			}
			tmp = tmp.next;
		}

		while (n1 != null) {
			tmp.next = n1;
			n1 = n1.next;
			tmp = tmp.next;
		}

		while (n2 != null) {
			tmp.next = n2;
			n2 = n2.next;
			tmp = tmp.next;
		}

		return dummy.next;
	}



}