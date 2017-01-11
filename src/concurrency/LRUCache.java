package concurrency;

import java.util.HashMap;

public class LRUCache<T> {

	int capacity;
	HashMap<Integer, LRUNode> map = new HashMap<>();
	LRUNode head = null;
	LRUNode end = null;
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	public T get(int key) throws Exception {
		if(map.containsKey(key)) {
			LRUNode node = map.get(key);
			remove(node);
			setHead(node);
			return (T)node.data;
		}
		
		throw new Exception("Key Not Found");
		
	}
	
	public void remove(LRUNode node) {
		if(node.prev != null) {
			node.prev.next = node.next;
		}
		else {
			this.head = node.next;
		}
		if (node.next != null ) {
			node.next.prev = node.prev;
		} else {
			this.end = node.prev;
		}
		
	}
	
	public void setHead(LRUNode node) {
		node.next = head;
		node.prev = null;
		if(this.head != null) {
			this.head.prev = node;
		}
		head = node;
		if (this.end == null) {
			end = node;
		}
	}

	public void set(int key, T value) {
		LRUNode node;
		if(this.map.containsKey(key)) {
			node = this.map.get(key);
			node.data = value;
			this.remove(node);
			this.setHead(node);
			
		} else {
			node= new LRUNode(key, value);
			if(this.map.size() >= capacity) {
				this.map.remove(this.end.key);
				remove(this.end);
			}
			this.map.put(key, node);
		}
		this.setHead(node);
		
		
		
	}
	
	public static void main(String[] args) {
		LRUCache<String> lruCache = new LRUCache<>(10);
		for(int i = 0;i<200;i++) {
			lruCache.set(i, "Value :" + i);
		}
		try {
		System.out.println(lruCache.get(195).toString());
		}catch(Exception exp) {
			System.out.println("Not Found");
		}
		System.out.println("Capacity:" + lruCache.map.size());
	}

}


class LRUNode<T> {
	int key;
	LRUNode prev;
	LRUNode next;
	T data;
	public LRUNode(int key, T data) {
		this.data = data;
		this.key = key;
	}
}
