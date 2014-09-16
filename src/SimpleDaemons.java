import java.util.concurrent.TimeUnit;


public class SimpleDaemons implements Runnable{
	
	public void run(){
			try {
				while(true){
					TimeUnit.MILLISECONDS.sleep(100);//通过休眠，起到切换线程的作用,可以设置不同的休眠时间，观察结果
					System.out.println(Thread.currentThread()+" "+this);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//此程序中运行时只有一个非后台线程：main线程。
	//当所有非后台线程都执行完，程序就终止了，同时会杀死所有后台线程
	public static void main(String[] args) {
		for(int i = 0;i<5;i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);//在start之前，将一个线程设置为后台线程
			daemon.start();
			System.out.println(daemon.isDaemon());
		}
		System.out.println("all daemons started");
		try {
			//main线程被设定为短暂睡眠，这时才可以看到后台线程启动结果。
			TimeUnit.MILLISECONDS.sleep(175);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
