package synchronize;


public class EatingThread implements Runnable{
	Apple apple;
	public EatingThread(Apple apple){
		this.apple = apple;
	}
	public void run(){
		for(int i=0;i<5;i++){
			apple.eating(10);
		}
	}
}
