package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		try {
			queueLock.lock();
			System.out.println("print a document:"+document);
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			queueLock.unlock();
		}
	}
}
