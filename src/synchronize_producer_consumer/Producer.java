package synchronize_producer_consumer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
	private Iphone6Factory iphone6f;
	public Producer(Iphone6Factory iphone6f){
		this.iphone6f = iphone6f;
	}
	public void run(){
		for(int i = 0;i<20;i++){
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iphone6 iphone6 = new Iphone6();
			iphone6f.set(iphone6);
			System.out.println("produce:"+iphone6.toString());
		}
	}
}
