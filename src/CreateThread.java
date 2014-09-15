
public class CreateThread {
	//没有为线程编写运行代码(run方法)，start之后这个线程就结束了
	public void justCreate(){
		Thread thread = new Thread();
		thread.start();
	}
	public static void main(String args[]){
		CreateThread ct = new CreateThread();
		ct.justCreate();
	}
}
