package synchronize;

import java.util.concurrent.TimeUnit;

//Apple现在是线程安全的不可变对象
public class Apple {
	private int apple = 0;
	public Apple(int apple){
		this.apple = apple;
	}
	public synchronized void eating(int number){
		int tmp = apple;//tmp保存进入临界区时apple的个数，在临界区中对apple的修改都针对tmp
		try {
			TimeUnit.SECONDS.sleep(1);//休眠1秒钟，当不使用Synchronized同步时，会立即暴露出错误。
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tmp>0){			
			tmp=tmp-number;
			System.out.println("eat "+number+",now have "+tmp+".");
		}
		else{
			System.out.println("no apple..");
		}
		apple = tmp;//在临界区结束时再把tmp的值赋给apple
	}
	public synchronized void giving(int number){
		int tmp = apple;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tmp>=200){
			System.out.println("full..");
		}
		else{
			tmp+=number;
			System.out.println("giving "+number+",now have "+tmp+".");
		}
		apple = tmp;
	}
}
