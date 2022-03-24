package main.linked.list.singly.list;

/*
 * 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 * 
 */

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		// addTwoNumbers2(l1, l2).print();
		// addTwoNumbers(l1, l2).print();
		// System.out.println();

		ListNode l3 = new ListNode(9,
				new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
		addTwoNumbers(l3, l4).print();
		addTwoNumbers2(l3, l4).print();

		// System.out.println();

		ListNode l5 = new ListNode(5, new ListNode(4, new ListNode(3)));
		ListNode l6 = new ListNode(5, new ListNode(6, new ListNode(4)));
		// addTwoNumbers2(l5, l6).print();
		// addTwoNumbers(l5, l6).print();
		// System.out.println();

		ListNode l7 = new ListNode(5, new ListNode(6));
		ListNode l8 = new ListNode(5, new ListNode(4, new ListNode(9)));
		// addTwoNumbers2(l7, l8).print();
		// addTwoNumbers(l7, l8).print();
		// System.out.println();
		ListNode l9 = new ListNode(9);
		ListNode l10 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
				new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
		// addTwoNumbers2(l9, l10).print();
		// addTwoNumbers(l9, l10).print();
		/**
		 * Input [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1] [5,6,4]
		 * Output [2,8,0,4,6,2,5,0,3,0,7,2,4,4,9,6,7,0,5] Expected
		 * [6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
		 */

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 != null || l2 != null) {
			ListNode head = new ListNode();
			ListNode currNode = head;
			int count = 0;
			long intResult = 0, n = 1;

			if (l1 != null) {
				while (l1 != null) {
					intResult = intResult += (l1.val * n);
					l1 = l1.next;
					n = n * 10;
				}
			}
			n = 1;
			if (l2 != null) {
				while (l2 != null) {
					intResult = intResult += (l2.val * n);
					l2 = l2.next;
					n = n * 10;
				}
			}

			while (intResult != 0) {
				if (head.val == 0 && head.next == null && count == 0) {
					long res = intResult % 10;
					head = new ListNode((int) res);
					currNode = head;
					count++;
					intResult = intResult / 10;
				} else {
					long res = intResult % 10;
					ListNode tmp = new ListNode((int) res);
					currNode.next = tmp;
					currNode = tmp;
					intResult = intResult / 10;
				}
			}
			return head;
		} else {
			return null;
		}
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int rem = 0;
		int res, count = 0;
		ListNode head = new ListNode();
		ListNode currNode = head;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				res = l1.val + l2.val + rem;
				rem = res / 10;
				if (head.val == 0 && head.next == null && count == 0) {
					head = new ListNode(res % 10);
					currNode = head;
					count++;
				} else {
					ListNode tmp = new ListNode(res % 10);
					currNode.next = tmp;
					currNode = tmp;
				}
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 == null && l2 != null) {
				res = l2.val + rem;
				rem = res / 10;
				ListNode tmp = new ListNode(res % 10);
				currNode.next = tmp;
				currNode = tmp;
				l2 = l2.next;
			}

			else if (l2 == null && l1 != null) {
				res = l1.val + rem;
				rem = res / 10;
				ListNode tmp = new ListNode(res % 10);
				currNode.next = tmp;
				currNode = tmp;
				l1 = l1.next;
			}
		}
		if (rem > 0) {
			ListNode tmp = new ListNode(rem);
			currNode.next = tmp;
		}
		return head;
	}
}
