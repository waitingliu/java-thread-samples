package synchronize_producer_consumer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	private Iphone6Factory iphone6f;
	public Consumer(Iphone6Factory iphone6f){
		this.iphone6f = iphone6f;
	}
	public void run(){
		for(int i=0;i<11;i++){
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iphone6 myIphone6 = iphone6f.get();
			System.out.println("buy"+myIphone6.toString());
		}
	}
}
