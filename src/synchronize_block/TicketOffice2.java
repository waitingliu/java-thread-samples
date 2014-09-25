package synchronize_block;

public class TicketOffice2 implements Runnable{
	private Cinema cinema;
	public TicketOffice2(Cinema cinema){
		this.cinema = cinema;
	}
	public void run(){
		cinema.sellTickets1(1);
		cinema.sellTickets2(2);
		cinema.sellTickets2(2);
		cinema.sellTickets1(2);
		cinema.returnTickets1(1);
		cinema.sellTickets1(1);
	}
}
