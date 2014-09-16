import java.util.Date;


public class MyRunnable implements Runnable{
	public static int count = 0;
	@Override
	public void run() {
		for(int i =0; i< 100;i++){
		count++;
		System.out.println(Thread.currentThread().getName()+":count-"+count);
		}
		//System.out.println("create a new thread");
	}
	public static void main(String args[]){
		Thread thread1 = new Thread(new MyRunnable());//必须将实现了Runnable接口的类对象附着在线程上，才会实现线程行为。单纯调用run方法不会产生任何线程能力
		Thread thread2 = new Thread(new MyRunnable());
		thread1.start();
		thread2.start();
		System.out.println(count);
	}
}
