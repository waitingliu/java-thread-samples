package catchException;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * Thread.UncaughtExceptionHandler接口的实现。
 * 为每个Thread对象都添加一个异常处理器
 * 原本线程中无法捕获的异常将会通过此接口的uncaughtException方法捕获
 * */
public class MyUnCaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught:"+e);
	}

}
