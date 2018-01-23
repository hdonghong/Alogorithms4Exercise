import java.util.Iterator;

/**
 * @ClassName	MyStack	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 15:33:20
 */
public class MyStack<Item> implements Iterable<Item> {

	private Node first;	//栈顶
	private int N;		// 栈中元素数量
	private class Node {
		// 定义结点的内部类
		Item item;
		Node next;
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}
	
	/**
	 * 栈大小
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 元素压栈
	 * @param item
	 */
	public void push(Item item) {
/*		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;*/
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		
		private Node currentNode = first;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			Item item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
	
		public void remove() {}
	}
	
	
	/**
	 * 测试用例  to be or not to - be - - that - - - is
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack<String> s = new MyStack<>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("( " + s.size() + " left on stack )");
	}

}
