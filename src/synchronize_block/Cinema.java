package synchronize_block;

public class Cinema {
	private long cinema1Count;//电影院1票数
	private long cinema2Count;//电影院2票数
	private final Object control1,control2;
	public Cinema(){
		control1 = new Object();
		control2 = new Object();
		cinema1Count=20;
		cinema2Count=20;
	}
	//电影院1售票
	public boolean sellTickets1(int number){
		//用synchronized保护代码块时，需要传入一个对象作参数
		//电影院1电影院2各自都有自己的临界区需要保护，这里我们设置两个不同的对象来对他们分别控制。
		//control1控制cinema1的临界区，同一时间，只能有一个线程访问control1对象的代码保护块，修改cinema1
		//control2控制cinema2的临界区，同一时间，只能有一个线程修改cinema2
		//control1和control2是不同对象，所以可以同时运行两个线程，一个修改cinema1,另一个修改cinema2
		synchronized(control1){
			if(number<cinema1Count){
				cinema1Count-=number;
				return true;
			}
			else{
				return false;
			}
			
		}
	}
	//电影院1售票
	public boolean sellTickets2(int number){
		synchronized(control2){
			if(number<cinema2Count){
				cinema2Count-=number;
				return true;
			}
			else{
				return false;
			}
			
		}
	}
	//电影院1退票
	public boolean returnTickets1(int number){
		
		synchronized(control1){
			cinema1Count+=number;
			return true;
		}
	}
	//电影院2退票
	public boolean returnTickets2(int number){
		synchronized(control2){
			cinema2Count+=number;
			return true;
		}
	}
	public long getCinema1Count(){
		return cinema1Count;
	}
	public long getCinema2Count(){
		return cinema2Count;
	}
}
