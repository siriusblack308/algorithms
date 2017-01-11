package concurrency;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class Stack<T> {
	private volatile AtomicReference<Node<T>> head = new AtomicReference<>();
	
	void push(T data) {

		
		boolean update = false;
		while(!update) {
			Node<T> existingNode = head.get();
			Node<T> newNode = new Node<>();
			newNode.data = data;
			newNode.next = existingNode;
			update = head.compareAndSet(existingNode, newNode);
		}
	}
	
	T pop() {
		
		T payload = null;
		boolean update = false;
		while(!update) {
			Node<T> existingNode = head.get();
			if(head == null) {
				return null;
			}
			payload = existingNode.data;
			update = head.compareAndSet(existingNode, existingNode.next);
		}
		return payload;
	}
	
	
	
}


class Node<T> {
	T data;
	Node<T> next = null;
}