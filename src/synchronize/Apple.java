package synchronize;

//Apple现在是线程安全的不可变对象
public class Apple {
	private int apple = 0;
	public Apple(int apple){
		this.apple = apple;
	}
	public void eating(int number){
		if(this.count()>0){			
			apple=apple-number;
			System.out.println("eat "+number+",now have "+count()+".");
		}
		else{
			System.out.println("no apple..");
			Thread.yield();
		}
	}
	public synchronized void giving(int number){
		if(this.count()>=20){
			System.out.println("full..");
			Thread.yield();
		}
		else{
			apple=apple+number;
			System.out.println("giving "+number+",now have "+count()+".");
		}
	}
	public synchronized int count(){
		return this.apple;
	}
}
