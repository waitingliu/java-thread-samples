package synchronize;

public class GivingThread implements Runnable{
	Apple apple;
	public GivingThread(Apple apple){
		this.apple = apple;
	}
	public void run(){
		for(int i=0;i<5;i++){
			apple.giving(1);
		}
	}
}
