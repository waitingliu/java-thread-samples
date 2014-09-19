package synchronize;


public class EatingThread implements Runnable{
	Apple apple;
	public EatingThread(Apple apple){
		this.apple = apple;
	}
	public void run(){
		
		System.out.print("eating:");
		apple.eating(1);
		System.out.println("-1,now "+apple.count());
	}
}
