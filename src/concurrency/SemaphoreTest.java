package concurrency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class SemaphoreTest {

	 private final Semaphore available = new Semaphore(100,true);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SemaphoreTest semaphore = new SemaphoreTest();
		System.out.println(semaphore.available.availablePermits());
		try {
			semaphore.available.acquire(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.available.release(100);
		
		
		System.out.println(semaphore.available.availablePermits());
		
		try {
			semaphore.available.acquire(190);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(semaphore.available.availablePermits());
		Thread.interrupted();
		List<String> list = new ArrayList<String>();
		Queue<String> queue = new ArrayDeque<String>(); 
		
		

	}

}
