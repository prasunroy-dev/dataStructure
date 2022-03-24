package main.linked.list.singly.list;

//Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public void print() {
		ListNode head = this;
		System.out.print("[");
		do {
			System.out.print(head.val + "");
			if (head.next != null)
				System.out.print(", ");
			head = head.next;
		} while (head != null);
		System.out.println("]");
	}
}
