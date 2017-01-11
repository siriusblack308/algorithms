package test;

public class Test {

	public static void main(String[] args) {
		Thread Th = new Thread(new TestRun());
		//Th.start();
		String aa = "abc";
		System.out.println("output"+aa.substring(0,1));
		//(new TestThread()).start();
		
	}
}

class TestRun implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Hellow Wrld\n");
	}
	

}

 class TestThread extends Thread {
	 
	 public void run() {
			System.out.println("Hellow Wrld Thread\n");
		}
		
 }
