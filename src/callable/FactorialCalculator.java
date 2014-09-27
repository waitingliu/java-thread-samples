package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//实现Callable接口而非Runnable接口，可以返回结果
//这里模拟阶乘的功能，返回结果应当是一个整型的数据，这里实现Callable<Integer>
public class FactorialCalculator implements Callable<Integer>{
	private Integer number;
	public FactorialCalculator(Integer number){
		this.number = number;
	}
	//实现call方法:获取返回的结果，整型
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(number==0||number==1){
			result = 1;
		}
		else{
			for(int i=2;i<=number;i++){
				result*=i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+result);
		return result;
	}
	//在执行器中执行任务并返回结果
	public static void main(String args[]){
		//执行器的线程池最大线程数是2
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		//存放所有任务返回的对应的Future对象
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		//创建10个任务，计算某个整数的阶乘
		for(int i=0;i<10;i++){
			Integer number = random.nextInt(10);//产生0-10之间的一个随机数
			FactorialCalculator fc = new FactorialCalculator(number);
			//将实现的Callable作为参数传递给executor,和Runnable类似；
			//executor.submit将返回一个Future对象
			//Future对象可以用来获取Callable产生的结果，并管理他们的状态
			Future<Integer> result = executor.submit(fc);
			
			resultList.add(result);
		}
		//在10个任务都完成之前，实时监控任务状态
		do{
			System.out.println(executor.getCompletedTaskCount()+" tasks completed.");
			for(int i=0;i<resultList.size();i++){
				Future<Integer> result = resultList.get(i);
				//通过Future对象管理任务的状态 
				System.out.println("Task "+i+":"+result.isDone());
			}
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(executor.getCompletedTaskCount()<resultList.size());
		//10个任务都完成，查看最终结果
		System.out.println("results:");
		for(int i=0;i<resultList.size();i++){
			Future<Integer> result=resultList.get(i);
			Integer number = null;
			try {
				//通过Future对象的get()方法获取任务返回的结果
				//get()方法一直等待直到call()方法执行完并返回结果
				number = result.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("task "+i+": "+number);
		}
		//关闭Executor
		executor.shutdown();
	}

}
