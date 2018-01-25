import java.util.Iterator;

/**
 * @ClassName	List	
 * @Description	删除链表的尾结点
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 16:06:47
 */
public class Ex_1_3_19<Item> implements Iterable<Item> {

	private int N;		// 记录元素数量
	private Node first; // 首结点
	private class Node {
		Item item;
		Node next;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return null;
	}
}
