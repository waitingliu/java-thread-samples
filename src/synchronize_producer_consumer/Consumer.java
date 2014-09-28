package synchronize_producer_consumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	private Iphone6Factory iphone6f;
	private int count;
	public Consumer(Iphone6Factory iphone6f,int count){
		this.iphone6f = iphone6f;
		this.count = count;
	}
	public void run(){
		for(int i=0;i<count;i++){
			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iphone6 myIphone6 = iphone6f.get();
			System.out.println("buy"+myIphone6.toString());
		}
	}
}
