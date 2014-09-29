import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyExecutor {
	public static void main(String args[]){
		//ExecutorService接口类似于一个线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=1;i<5;i++){
			//使用execute方法代替显式创建Thread对象。
			exec.execute(new Fibonacci(10));
		}
		//result = exec.invokeAny(tasks);执行器收到一个任务列表，运行里面的所有任务，并返回第一个完成的任务的执行结果
		//resultList = exec.invokeAll();等待所有任务完成，返回所有任务的执行结果
		exec.shutdown();//关闭executorService是在所有任务都执行完之后。
		//确保shutdown()之后不再有任何任务的创建和调用。
		//否则会抛出：java.util.concurrent.RejectedExecutionException
	}
}
