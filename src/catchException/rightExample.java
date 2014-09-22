package catchException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rightExample implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new rightExample());
		exec.shutdown();
	}


}
