package main.linked.list.singly.list;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists.length==0) {
			return null;
		}else if(lists.length==1) {
			return lists[0];
		}else {
		 ListNode head=null;
		 ListNode tmp=null;
		 
		 for(int i=0;i<lists.length;i++) {
			 mergeTwoLists(tmp, lists[i], head);
			 tmp=head;
		 }
	      
		 return head;
		}
	    }

	private void mergeTwoLists(ListNode list1, ListNode list2, ListNode head) {
		if (list1 == null && list2 == null)
			return;
		else {

			ListNode tmp = null;
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
					if (tmp == null) {
						head = list2;
						return;
					} else {
						tmp.next = list2;
						tmp = tmp.next;
					}
				}
				if (list2 == null) {
					if (tmp == null) {
						head = list1;
						return;
					} else {
						tmp.next = list1;
						tmp = tmp.next;
					}
				}
			}
			return;
		}
	}

}
