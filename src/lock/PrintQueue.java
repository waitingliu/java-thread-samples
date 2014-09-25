package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	//ReentrantLock是Lock接口的实现类
	//Lock允许多个读线程和一个写线程
	//比Synchronized关键字性能更好，更灵活（控制的获取和释放不需要出现在同一个块结构中）
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		try {
			queueLock.lock();//上锁
			//模拟打印行为
			System.out.println(Thread.currentThread().getName()+" print a document:"+document);
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			queueLock.unlock();//解锁
		}
	}
}
