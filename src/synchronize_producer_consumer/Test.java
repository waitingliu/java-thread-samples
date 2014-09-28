package synchronize_producer_consumer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		Iphone6Factory ipf = new Iphone6Factory(10);
		Producer p = new Producer(ipf,15);
		Consumer c = new Consumer(ipf,10);
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		executor.execute(c);
		executor.execute(p);
		executor.shutdown();
		//等待所有任务完成
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("库存："+ipf.getStorage());
	}

}
