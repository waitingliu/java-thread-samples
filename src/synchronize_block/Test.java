package synchronize_block;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cinema cinema = new Cinema();
		TicketOffice1 to1 = new TicketOffice1(cinema);
		TicketOffice2 to2 = new TicketOffice2(cinema);
		Thread thread1 = new Thread(to1);
		Thread thread2 = new Thread(to2);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cinema1:"+cinema.getCinema1Count()+" tickets remain.");
		System.out.println("Cinema2:"+cinema.getCinema2Count()+" tickets remain.");
	}

}
