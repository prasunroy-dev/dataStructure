package main.linked.list.singly.list;

/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		//ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		 ListNode ln=new ListNode(1, new ListNode(2));
		ln.print();
		reverseList(ln).print();
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode curr = head.next;
			ListNode tmp = curr.next;
			head.next = null;

			if (tmp == null) {
				curr.next = head;
				return curr;
			} else {
				do {
					curr.next = head;
					head = curr;
					curr = tmp;
					tmp = tmp.next;
				} while (tmp != null);

				curr.next = head;
				return curr;
			}

		}
	}

}
