package synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		Apple apple = new Apple(10);
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++){
			ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
			exec.execute(new EatingThread(apple));
			exec.execute(new GivingThread(apple));
			Thread.yield();
		}
	}

}
