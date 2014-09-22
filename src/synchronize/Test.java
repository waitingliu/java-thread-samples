package synchronize;


public class Test {
	
	public static void main(String[] args) {
		Apple apple = new Apple(10);
		// TODO Auto-generated method stub
		new Thread(new EatingThread(apple)).start();
		new Thread(new EatingThread(apple)).start();
		new Thread(new GivingThread(apple)).start();
		new Thread(new GivingThread(apple)).start();
		/*ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
		exec.execute(new EatingThread(apple));
		exec.execute(new GivingThread(apple));
		exec.shutdown();
		*/
	}

}
