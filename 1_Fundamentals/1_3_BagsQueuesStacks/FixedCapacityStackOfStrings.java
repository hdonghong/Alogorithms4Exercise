
/**
 * @ClassName	FixedCapacityStackOfStrings	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 10:36:52
 */
public class FixedCapacityStackOfStrings {

	private String[] stack;
	private int cap = 100;
	private int point;
	
	/**
	 * 创建一个容量为cap的空栈
	 */
	public FixedCapacityStackOfStrings() {
		stack = new String[cap];
	}
	/**
	 * 创建一个容量为cap的空栈
	 * @param cap
	 */
	public FixedCapacityStackOfStrings(int cap) {
		stack = new String[cap];
		this.cap = cap;
	}
	
	/**
	 * 添加一个字符串
	 * @param item
	 */
	public void push(String item) {
		if (point < cap)
			stack[point++] = item;
	}
	
	/**
	 * 弹栈
	 * @return
	 */
	public String pop() {
		return stack[--point];
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return point == 0;
	}
	
	/**
	 * 栈中字符串的数量
	 */
	public int size() {
		return point;
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("( " + s.size() + " left on stack )");
	}
}
