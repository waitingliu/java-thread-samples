package synchronize_producer_consumer;

import java.util.LinkedList;
import java.util.List;

public class Iphone6Factory {
	//最大库存量
	private int maxSize;
	//Iphone库存
	private List<Iphone6> storage;
	
	public Iphone6Factory(int maxSize){
		this.maxSize = maxSize;
		this.storage = new LinkedList<>();
	}
	public synchronized void set(Iphone6 iphone6){
		while(storage.size()==maxSize){
			try {
				System.out.println("别生产了，库满了，正在寻找买家..");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(iphone6);
		notifyAll();
	}
	public synchronized Iphone6 get(){
		while(storage.size()==0){
			try {
				System.out.println("缺货中，正在玩命生产..");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int random = (int) (Math.random()*(storage.size()-1));
		Iphone6 iphone6 = storage.get(random);
		storage.remove(random);
		notifyAll();
		return iphone6;
	}
}
