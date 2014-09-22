package immutable;

public class ImmutableValue {
	//成员变量是通过构造方法来赋值的。
	//这意味着，一旦ImmutableValue的实例被创建，value得到赋值，就再也没有任何方法可以改变此变量的值，即不可变性。
	private int value =0;
	public ImmutableValue(int value){
		this.value = value;
	}
	//get方法可以读取这个变量的值
	public int getValue(){
		return this.value;
	}
	public static void main(String args[]){
		ImmutableValue iv = new ImmutableValue(100);//由此创建的对象是线程安全的不可变对象
		iv.getValue();
		//一个对象是线程安全的不可变对象，并不意味着对象的引用是线程安全的。
		@SuppressWarnings("unused")
		ImmutableValue iv2 = null;
		
	}
}
