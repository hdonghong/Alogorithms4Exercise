import java.util.Iterator;

/**
 * @ClassName	FixedCapacityStack	
 * @Description	改自FixedCapacityStackOfStrings.java
 * 				TODO表示修改处
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 10:59:19
 */
public class FixedCapacityStack<Item> {
	private Item[] stack;
	private int cap = 100;
	private int point;
	
	/**
	 * 创建一个容量为cap的空栈
	 */
	public FixedCapacityStack() {
		// TODO 不能创建泛型数组，只能转换类型
		stack = (Item[])new Object[cap];
	}
	/**
	 * 创建一个容量为cap的空栈
	 * @param cap
	 */
	public FixedCapacityStack(int cap) {
		// TODO
		stack = (Item[])new Object[cap];
		this.cap = cap;
	}
	
	/**
	 * 添加一个字符串
	 * @param item
	 */
	public void push(Item item) { // TODO
		if (point == cap) resize(cap << 1); // 防止栈溢出
		stack[point++] = item;
	}
	
	/**
	 * 弹栈
	 * @return
	 */
	public Item pop() {// TODO
		Item item = stack[--point];
		stack[point] = null; // 避免对象游离
		if (point > 0 && point == cap / 4) resize(cap / 2); // 保证栈空间使用率不低于四分之一
		return item;
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
	 * 栈空间扩容
	 * @param max
	 */
	public void resize(int max) {
		Item[] tempStack = (Item[]) new Object[cap = max];
		for (int i = 0; i < point; i++) {
			tempStack[i] = stack[i];
		}
		stack = tempStack;
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = point;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return stack[--i];
		}
		
		public void remove() {}
		
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		FixedCapacityStack<String> s = new FixedCapacityStack<>(2);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("( " + s.size() + " left on stack )");
	}
}
