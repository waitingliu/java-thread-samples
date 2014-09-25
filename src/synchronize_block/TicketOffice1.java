package synchronize_block;

public class TicketOffice1 implements Runnable{
	private Cinema cinema;
	public TicketOffice1(Cinema cinema){
		this.cinema = cinema;
	}
	public void run(){
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		cinema.sellTickets2(2);
		cinema.sellTickets2(4);
		cinema.returnTickets1(3);
		cinema.returnTickets2(2);
		cinema.sellTickets1(1);
		cinema.sellTickets2(2);
	}
	
}
