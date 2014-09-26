package readwriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Papers {
	private List papers;
	private ReadWriteLock lock;
	public Papers(List lists){
		this.papers = lists;
		lock = new ReentrantReadWriteLock();
	}
	public Object getPaper(){
		lock.readLock().lock();
		int paper = (int) (Math.random()*papers.size());
		Object op = papers.get(paper);
		papers.remove(paper);
		lock.readLock().unlock();
		return op;
	}
	public void setPaper(int index,String information){
		lock.writeLock().lock();
		Object paper = papers.get(index);
		System.out.println(paper+":"+information);
		lock.writeLock().unlock();
	}
}
