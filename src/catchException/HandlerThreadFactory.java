package catchException;

import java.util.concurrent.ThreadFactory;
/**
 * ThreadFactory接口实现
 * 用于生产自定义线程
 * 在此自定义的线程中为每个线程附加一个UncaughtExceptionHandler,这样就可以在thread中捕获异常了
 * */
public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
		return t;
	}

}
