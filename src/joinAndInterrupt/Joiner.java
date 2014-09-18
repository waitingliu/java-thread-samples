package joinAndInterrupt;

import java.util.concurrent.TimeUnit;

public class Joiner implements Runnable{
	private Sleeper sleeper;
	public Joiner(Sleeper sleeper){
		this.sleeper = sleeper;
	}
	@Override
	public void run() {
		System.out.println(toString()+":I am running.");
		//
		Thread thread = new Thread(sleeper);
		try {
			thread.join();
			System.out.println(toString()+":I joined the sleeper");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i =0;i<100;i++){
			System.out.println(toString()+":join done,keep working");
		}
		System.out.println("work done! It's time for the sleeper");
	}
	public String toString(){
		return "Joiner "+this.getClass().getName();
	}
	public static void main(String args[]){
		Sleeper sleeper = new Sleeper(3000);//Sleeper休眠3秒
		Thread thread1 = new Thread(sleeper);
		thread1.start();
		try {
			TimeUnit.MILLISECONDS.sleep(100);//主线程休眠0.1秒钟，等待sleeper睡着。
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//主线程醒来之后开启Joiner线程
		//Joiner线程开始执行，并调用join()方法等待Sleeper线程醒来,一旦醒来，立即切换到Sleeper线程去执行
		Thread thread = new Thread(new Joiner(sleeper));
		thread.start();
		//thread1.interrupt();//打断Sleeper休眠，使他立即醒来
	}
}
