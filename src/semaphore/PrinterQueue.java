package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrinterQueue {
	private final Semaphore semaphore;
	public PrinterQueue(int semNum){
		semaphore = new Semaphore(semNum);
	}
	//模拟打印一份文件任务
	public void print(Object document){
		try {
			//获取资源
			semaphore.acquire();
			//模拟打印
			System.out.println(Thread.currentThread().getName()+"-printing:"+document+"...");
			TimeUnit.MILLISECONDS.sleep(10000);
			System.out.println(Thread.currentThread().getName()+" work done");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			semaphore.release();
		}
	}
	
}
