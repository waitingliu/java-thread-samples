package lock;

/*Lock的简单实现*/
public class MyLock {
	private boolean isLocked = false;
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = false;
	}
	public synchronized void unlock() throws InterruptedException{
		isLocked=true;
		notify();
	}
}
