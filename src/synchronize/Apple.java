package synchronize;

public class Apple {
	private int apple;
	public Apple(int apple){
		this.apple = apple;
	}
	public synchronized void eating(int number){
		apple=apple-number;
		Thread.yield();
		apple=apple-number;
	}
	public synchronized void giving(int number){
		apple=apple+number;
		Thread.yield();
		apple=apple+number;
	}
	public synchronized int count(){
		return apple;
	}
}
