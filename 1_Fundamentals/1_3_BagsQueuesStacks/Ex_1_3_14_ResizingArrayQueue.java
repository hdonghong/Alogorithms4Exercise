import java.util.Iterator;

/**
 * @ClassName	Ex_1_3_14_ResizingArrayQueue	
 * @Description	使用定长数组实现队列的抽象，然后扩展实现调整数组的方法突破大小的限制，以下实现的是循环队列
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 14:59:42
 */
@SuppressWarnings("unchecked")
public class Ex_1_3_14_ResizingArrayQueue<Item> implements Iterable<Item> {

	private int N;
	private int first;
	private int last;
	private Item[] queue;
	
	public Ex_1_3_14_ResizingArrayQueue() {
		this(10);
	}
	
	public Ex_1_3_14_ResizingArrayQueue(int size) {
		queue = (Item[])new Object[size];
		N = 0;
		first = 0;
		last = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int newSize) {
		Item[] newQueue = (Item[]) new Object[newSize];
		for (int i = 0; i < N; i++)
			newQueue[i] = queue[(first + i) % queue.length];
		queue = newQueue;
		first = 0;
		last = N;
	}
	
	/**
	 * 入列
	 * @param item
	 */
	public void enqueue(Item item) {
		if (N == queue.length) resize(queue.length*2); 
		queue[last++] = item;
		if (last == queue.length) last = 0;
		N++;
	}
	
	/**
	 * 出列
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) return null;
		Item item = queue[first];
		queue[first] = null;
		first = (++first) % queue.length;
		N--;
		if (N > 0 && N == queue.length / 4) resize(queue.length / 2);
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public Item next() {
			return hasNext() ?
					queue[(first + i++) % queue.length] : null;
		}
		
		public void remove() {}
	}
	
	public static void main(String[] args) {
        Ex_1_3_14_ResizingArrayQueue<String> queue = new Ex_1_3_14_ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
	}
}
