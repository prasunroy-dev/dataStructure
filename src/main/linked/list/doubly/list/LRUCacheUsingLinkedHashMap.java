package main.linked.list.doubly.list;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap {

	Map<Integer, Integer> cache;
	int capacity;

	public LRUCacheUsingLinkedHashMap(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		int value = cache.get(key);
		cache.remove(key);
		cache.put(key, value);
		return value;
	}

	public void put(int key, int value) {
		if (!cache.containsKey(key)) {
			if (cache.size() == capacity) {
				int firstKey = cache.keySet().iterator().next();
				cache.remove(firstKey);
			}
			cache.put(key, value);

		} else {
			cache.remove(key);
			cache.put(key, value);
		}
	}


	/**
	 * Input:
	 * ------------------------------------------------------------------
	 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
	 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
	 * 
	 * Output:
	 * ------------------------------------------------------------
	 * [null, null, null, 1, null, 2, null, -1, -1, 4]
	 * 
	 */
	
	
	public static void main(String[] args) {
		List<Object> res = new LinkedList<>();
		
		LRUCacheUsingLinkedHashMap lRUCache = new LRUCacheUsingLinkedHashMap(2);
		res.add(null);
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

		System.out.println(res);

	}

}
