package main.linked.list.singly.list;
/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
 * 
 */

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
		// new ListNode(5)))));
		// ListNode<Integer> ln = new ListNode<Integer>(1, new ListNode<Integer>(2));
		ListNode ln = new ListNode(1);
		ln.print();
		removeNthFromEnd(ln, 1).print();
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || n <= 0) {
			return head;
		}
		if (head.next == null) {
			if (n == 1)
				head = head.next;

			return head;
		}
		ListNode curr = head, tmp = head;
		int currPosition = 1, tmpPosition = 1;
		do {
			curr = curr.next;
			currPosition++;
			if (currPosition - tmpPosition > n) {
				tmp = tmp.next;
				tmpPosition++;
			}
		} while (curr.next != null);

		if (currPosition - tmpPosition == n) {
			tmp.next = tmp.next.next;
		}
		if (currPosition - tmpPosition == n - 1) {
			head = head.next;
		}
		return head;
	}

}
