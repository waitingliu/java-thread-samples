
public class Fibonacci implements Runnable{
	public final int n;
	public Fibonacci(int n){
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Fibonacci("+n+")="+generator(n)+";");
	}
	public int generator(int n){
		if(n==1||n==2){
			return 1;
		}
		else if(n<1){
			return 0;
		}
		else{
			return generator(n-1)+generator(n-2);
		}
	}
	public static void main(String args[]){
		for(int j = 0; j<10;j++){
			new Thread(new Fibonacci(9)).start();
		}
	}
}
