package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class StringCallable implements Callable<String>{
	private String str;
	public StringCallable(String str){
		this.str = str;
	}
	@Override
	public String call() throws Exception {
		String result = null;
		result=str.toUpperCase();
		TimeUnit.MILLISECONDS.sleep(20);
		return result;
	}
	public static void main(String args[]){
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		List<Future<String>> slists = new ArrayList<>();
		StringCallable sc1 = new StringCallable("liuhuantian");
		StringCallable sc2 = new StringCallable("jiaxiaoru");
		StringCallable sc3 = new StringCallable("hello");
		StringCallable sc4 = new StringCallable("tom");
		StringCallable sc5 = new StringCallable("cat");
		Future<String> result1 = executor.submit(sc1);
		Future<String> result2 = executor.submit(sc2);
		Future<String> result3 = executor.submit(sc3);
		Future<String> result4 = executor.submit(sc4);
		Future<String> result5 = executor.submit(sc5);
		slists.add(result1);
		slists.add(result2);
		slists.add(result3);
		slists.add(result4);
		slists.add(result5);
		do{
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<slists.size();i++){
				System.out.println("task "+i+":"+slists.get(i).isDone());
			}
			System.out.println("------");
		}while(executor.getCompletedTaskCount()<slists.size());
		for(int i=0;i<slists.size();i++){
			try {
				System.out.println("task "+i+":"+slists.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
