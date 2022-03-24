package main.linked.list.singly.list;

public class ConvertBinaryNumberInALinkedListToInteger {

	public static void main(String[] args) {
		ListNode ln = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
		ListNode ln1 = new ListNode(1, new ListNode(0));

		System.out.println(getDecimalValue1(ln));

	}

	public static int getDecimalValue(ListNode head) {
		int decimal = 0;
		if(head!=null) {
			StringBuffer decimalString = new StringBuffer();

			while (head != null) {
				decimalString.append(head.val);
				head = head.next;
			}
			int binary = Integer.parseInt(decimalString.toString());
			
			int n = 0;
			while (true) {
				if (binary == 0) {
					break;
				} else {
					int temp = binary % 10;
					decimal += temp * Math.pow(2, n);
					binary = binary / 10;
					n++;
				}
			}
		}

		return decimal;
	}
	
	
	
	
	
	public static int getDecimalValue1(ListNode head) {
       int position = -1;
        return helper(head, position);
    }
	
	
	
	
	public static int helper(ListNode head, int position) {
        if (head == null) {
            position++;
            return 0;
        };
        
        int prevSum = helper(head.next, position);
        return prevSum + (head.val)*(1 << (position++));
    }
	

	
	 
}
