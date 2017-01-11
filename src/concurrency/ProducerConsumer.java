package concurrency;

import java.util.Vector;

public class ProducerConsumer {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> queue = new Vector<>();
		new Thread(new Producer(queue,10)).start();
		new Thread(new Consumer(queue,10)).start();
	}

}

class Producer implements Runnable {

	private Vector<String> queue;
	private volatile int size;
	Producer(Vector<String> Queue, int size) {
		this.queue = Queue;
		this.size = size;
	}
	@Override
	public void run() {

		int count = 0;
		while(true) {
			try {
				produce(count++);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
	}

	public void produce(int i) throws Exception{

		while(this.size == this.queue.size()) {
			synchronized(this.queue) {
				System.out.println("Waiting for consumer to finish it");
				this.queue.wait();
			}
			
		}
		synchronized(this.queue){
			System.out.println("Producing now");
			this.queue.addElement("" + i);
			this.queue.notifyAll();
		}
	}

}
	class Consumer implements Runnable {

		private Vector<String> queue;
		private volatile int size;
		Consumer(Vector<String> Queue, int size) {
			this.queue = Queue;
			this.size = size;
		}
		@Override
		public void run() {

			while(true) {
				try {
					consume();
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void consume() throws Exception {
			while(this.queue.isEmpty()) {
					synchronized(this.queue) {
						System.out.println("Queue is empty");
						this.queue.wait();
					}
			}
			synchronized(this.queue) {
				this.queue.notifyAll();
				
				System.out.println("Consuming Qeueue " + this.queue.get(0));
				this.queue.remove(0);
			}
		}

}

