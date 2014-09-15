import java.util.Date;


public class MyThread extends Thread{
	//重写Thread类的run方法
	public void run(){
		Date date = new Date();
		System.out.println("create a new thread:"+date);
	}
	public static void main(String args[]){
		MyThread mt = new MyThread();
		//start方法一旦执行，就产生了一个新线程，由新线程去执行run方法，而start方法会立即返回主线程。
		//创建新线程必须是通过调用start方法，而非run方法。
		//如果直接调用run方法，其实是主线程在执行，并不会创建新线程
		mt.start();
		String threadName = Thread.currentThread().getName();//得到当前线程名
		System.out.println(threadName);//发现当前是主线程
	}
}
