package concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeLinkedList<T> {

	public static void main(String[] args) {
		LinkedList<Integer> integerList = new LinkedList<>();
		integerList.insertNode(new Integer(1));
		integerList.insertNode(new Integer(2));
		integerList.insertNode(new Integer(3));
		integerList.insertNode(new Integer(4));
		
		integerList.printNodes();

	}

}


class LinkedList<T> {

	LinkedNode<T> head = null;
	LinkedList() {
		LinkedNode<T> headNode = new LinkedNode<>();
		headNode.data = null;
		headNode.nextNode.set(null);
		head = headNode;

	}

	public void insertNode(T nodeData) {

		LinkedNode<T> newNode = new LinkedNode<>();
		newNode.data = nodeData;
		LinkedNode<T> currHead = head;
		boolean update = false;
		while(!update) {
			if(currHead.nextNode.get() != null) {
				currHead = currHead.nextNode.get();
				continue;
			}
			update = currHead.nextNode.compareAndSet(null, newNode);
		}



	}

	public void printNodes() {
		LinkedNode<T> currNode = head;
		while(currNode != null) {
			System.out.println("Current Node:" + currNode.data);
			currNode = currNode.nextNode.get();
		}

	}


}


class LinkedNode<T> {

	T data;
	AtomicReference<LinkedNode<T>> nextNode = new AtomicReference<>();

}