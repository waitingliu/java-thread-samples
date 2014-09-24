package synchronize;


public class Test {
	
	public static void main(String[] args) {
		Apple apple = new Apple(100);
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new EatingThread(apple));
		Thread t2 = new Thread(new GivingThread(apple));
		/*ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
		exec.execute(new EatingThread(apple));
		exec.execute(new GivingThread(apple));
		exec.shutdown();
		*/
		t1.start();
		t2.start();
		try {
			t1.join();//等待‘吃线程’和‘给线程’执行完
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
