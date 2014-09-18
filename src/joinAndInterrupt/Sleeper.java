package joinAndInterrupt;

import java.util.concurrent.TimeUnit;

public class Sleeper implements Runnable{
	private int sleepTime;
	
	public Sleeper(int sleepTime){
		this.sleepTime = sleepTime;
	}
	public void run(){
		System.out.println(toString()+":I gonna to sleep.");
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			System.out.println("sleep was interrupted");
		}
		System.out.println(toString()+":I wake up");
		for(int i =0;i<100;i++){
			System.out.println(toString()+":keep going");
		}
	}
	public String toString(){
		return "Sleeper "+this.getClass().getName();
	}
}
