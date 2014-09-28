package synchronize_producer_consumer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
	private Iphone6Factory iphone6f;
	private int count;
	public Producer(Iphone6Factory iphone6f,int count){
		this.iphone6f = iphone6f;
		this.count = count;
	}
	public void run(){
		for(int i = 0;i<count;i++){
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Iphone6 iphone6 = new Iphone6();
			iphone6f.set(iphone6);
			System.out.println("produce:"+iphone6.toString());
		}
	}
}
