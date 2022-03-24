package main.linked.list.doubly.list;

import java.util.LinkedList;
import java.util.List;

public class LRUCacheUsingLL {
	Node head = null;
	final int capacity;
	int currentSize = 0;

	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUCacheUsingLL(int capacity){
		if (capacity > 0)
			this.capacity = capacity;
		else
			this.capacity = -1;
	}

	public void put(int key, int value) {
		Node curr = head;
		if (currentSize == 0) {
			head = new Node(key, value);
			currentSize++;
		} else {

			while (curr.next != null) {
				if (curr.key == key) {
					curr.value = value;
					if(curr.prev==null) {
						return;
					}
					curr.prev.next = curr.next;
					if(curr.next!=null) {
						curr.next.prev = curr.prev;
					}
					curr.prev = null;
					curr.next = head;
					head.prev = curr;
					head = curr;
					return;
				}
				curr = curr.next;
			}
			
			if (curr.key == key) {
				curr.value = value;
				if(curr.prev==null) {
					return;
				}
				curr.prev.next = curr.next;
				if(curr.next!=null) {
					curr.next.prev = curr.prev;
				}
				curr.prev = null;
				curr.next = head;
				head.prev = curr;
				head = curr;
				return;
			}
			
			if (currentSize < capacity) {
				Node tmp = new Node(key, value);
				tmp.next = head;
				head.prev = tmp;
				head = tmp;
				currentSize++;
			} else {
				if(capacity==1) {
					head=new Node(key, value);
				}else {
					if(curr.prev!=null)
						curr.prev.next = null;
						Node tmp = new Node(key, value);
						tmp.next = head;
						head.prev = tmp;
						head = tmp;
				}
				
			}
		}

	}

	public int get(int key) {
		if (head != null) {
			Node curr = head;
			while (curr != null) {
				if (curr.key == key) {
					int val = curr.value;
					if(curr.prev==null) {
						return val;
					}
					curr.prev.next = curr.next;
					if(curr.next!=null) {
						curr.next.prev = curr.prev;
					}
					curr.prev = null;
					curr.next = head;
					head.prev = curr;
					head = curr;
					return val;
				}
				curr = curr.next;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		/**
		 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
		 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		 */
		List<Object> res = new LinkedList<>();
		//LRUCache lRUCache = new LRUCache(2);
		/*res.add(null);
		lRUCache.put(1, 1); // cache is {1=1}
		res.add(null);
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		res.add(null);
		res.add(lRUCache.get(1)); // return 1
		lRUCache.put(1, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		res.add(null);
		res.add(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		res.add(null);
		res.add(lRUCache.get(1)); // return -1 (not found)
		res.add(lRUCache.get(3)); // return 3
		res.add(lRUCache.get(4)); // return 4
		*/
		
		//------------------------
		
		//["LRUCache","put","get","put","get","get"]
		//		[[1],[2,1],[2],[3,2],[2],[3]]
		
		LRUCacheUsingLL lRUCache = new LRUCacheUsingLL(1);
		res.add(null);
		res.add(lRUCache.get(1));
		lRUCache.put(2, 1);
		res.add(null);
		res.add(lRUCache.get(2));
		lRUCache.put(3, 2);
		res.add(null);
		res.add(lRUCache.get(2));
		res.add(lRUCache.get(3));

		System.out.println(res);

	}

}
