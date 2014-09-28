package semaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrintTask implements Runnable{
	private PrinterQueue printer;
	private Object document;
	public PrintTask(PrinterQueue printer,Object document){
		this.printer = printer;
		this.document = document;
	}
	@Override
	public void run() {
		
		printer.print(this.document);
	}
	public static void main(String[] args){
		PrinterQueue printer = new PrinterQueue(5);
		//线程池大小为3，所以并发打印线程数为3
		//ExecutorService es = Executors.newFixedThreadPool(3);
		//线程池动态，所以并发打印线程为5（信号量大小），即共享资源总个数
		ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		for(int i = 0;i<10;i++){
			//每隔一秒发起一个打印任务
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Object doc = new Object();
			PrintTask pt = new PrintTask(printer,doc);
			es.execute(pt);
			System.out.println("打印进程数："+es.getActiveCount());
			//可以看到打印进程数可能会超过5，但是第六个线程总是在前面的某个线程打印完之后才开始运行。证明这个信号量是起作用的
		}
		es.shutdown();
	}
}
