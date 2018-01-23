import java.util.Iterator;

/**
 * @ClassName	Bag	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 16:48:42
 */
public class MyBag<Item> implements Iterable<Item> {

	private int N;
	private Node first; // 首结点
	private class Node {
		Item item;
		Node next;
	}
	
	public void add(Item item) {
		// 实现同MyStack.push(..)
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
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

	
}
