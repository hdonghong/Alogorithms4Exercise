import java.util.Iterator;

/**
 * @ClassName	Queue	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 16:01:08
 */
public class Queue<Item> implements Iterable<Item> {

	private int N;		// 队列中元素数量
	private Node first;	// 头指针
	private Node last;	// 尾指针
	private class Node {// 定义结点的内部类
		Item item;
		Node next;
	}
	
	/**
	 * 添加一个元素
	 * @param item
	 */
	void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}
	
	/**
	 * 删除队首元素
	 * @return
	 */
	Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	boolean isEmpty() {return N == 0;}
	
	/**
	 * 队列中的元素数量
	 * @return
	 */
	int size() {return N;}
	
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
		
	}
	
	/**
	 * 测试用例：to be or not to - be - - that - - - is
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) q.enqueue(item);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
