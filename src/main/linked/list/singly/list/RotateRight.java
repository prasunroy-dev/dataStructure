package main.linked.list.singly.list;

public class RotateRight {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		rotateRight(l1, 2).print();;

	}
	
	 public static ListNode rotateRight(ListNode head, int k) {
	        if(head!=null){
	            int nodeCount=0;
	            ListNode currNode=head;
	            while(currNode!=null){
	                nodeCount++;
	                currNode=currNode.next;
	            }
	            k=k%nodeCount;
	            int n=1;
	            currNode=head;
	            ListNode tmp=null;
	            while(currNode.next!=null){
	                if(n==nodeCount-k){
	                   tmp=currNode;
	                }
	                currNode=currNode.next;
	                n++;
	            } 
	            if(tmp!=null){
	                currNode.next=head;
	                head=tmp.next;
	                tmp.next=null;
	            } 
	        } 
	        return head;
	    }

}
