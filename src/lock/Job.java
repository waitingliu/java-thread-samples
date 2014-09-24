package lock;

public class Job implements Runnable{
	private PrintQueue printq;
	public Job(PrintQueue printq){
		this.printq = printq;
	}
	public void run(){
		System.out.println("Job running");
		printq.printJob(new Object());
	}
	public static void main(String args[]){
		PrintQueue printq = new PrintQueue();
		for(int i = 0;i<10;i++){
			Thread thread = new Thread(new Job(printq));
			thread.start();
		}
	}
}
