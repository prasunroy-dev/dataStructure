package main.linked.list.singly.list;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

		//mergeTwoLists(l1, l2).print();
		System.out.println();

		ListNode l3 = new ListNode();
		ListNode l4 = new ListNode(0, new ListNode(1));
		 mergeTwoLists(null, l4).print();

		System.out.println();

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null)
			return null;
		else {

			ListNode head = list1, tmp = null;
			if (list1 != null || list2 != null) {
				while (list1 != null && list2 != null) {
					if (list1.val <= list2.val) {
						if (tmp == null)
							tmp = list1;
						else {
							tmp.next = list1;
							tmp = tmp.next;
						}
						list1 = list1.next;
					} else {
						if (tmp == null) {
							tmp = list2;
							head = list2;
						} else {
							tmp.next = list2;
							tmp = tmp.next;
						}

						list2 = list2.next;
					}
				}

				if (list1 == null) {
					if (tmp == null)
						return list2;
					else {
						tmp.next = list2;
						tmp = tmp.next;
					}
				}

				if (list2 == null) {
					if (tmp == null)
						return list1;
					else {
						tmp.next = list1;
						tmp = tmp.next;
					}
				}
			}
			return head;
		}
	}

}
