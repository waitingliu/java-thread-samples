package synchronize;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		System.out.println("new thread.");
		return t;
	}
}
