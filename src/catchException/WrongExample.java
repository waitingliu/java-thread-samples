package catchException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WrongExample implements Runnable{
	

	@Override
	public void run() {
		throw new RuntimeException();//在线程执行过程中主动抛出异常
		//线程中的异常无法捕获，最终导致线程死亡，异常向外传播到控制台
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WrongExample());
		exec.shutdown();
	}
}
