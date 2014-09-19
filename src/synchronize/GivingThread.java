package synchronize;

public class GivingThread implements Runnable{
	Apple apple;
	public GivingThread(Apple apple){
		this.apple = apple;
	}
	public void run(){
		
		System.out.print("giving:");
		apple.giving(1);
		System.out.println("+1,now "+apple.count());
	}
}
