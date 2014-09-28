package synchronize_producer_consumer;

public class Test {
	public static void main(String[] args) {
		Iphone6Factory ipf = new Iphone6Factory(10);
		Producer p = new Producer(ipf);
		Consumer c = new Consumer(ipf);
		Thread thread1 = new Thread(p);
		Thread thread2 = new Thread(c);
		thread1.start();
		thread2.start();
		
	}

}
