import java.util.Date;


public class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("create a new thread");
	}
	public static void main(String args[]){
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}
