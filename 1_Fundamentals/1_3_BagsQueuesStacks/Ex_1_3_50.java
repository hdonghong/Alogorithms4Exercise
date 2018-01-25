import java.util.Iterator;

/**
 * @ClassName	Ex_1_3_50	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 19:19:42
 */
public class Ex_1_3_50 {

	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		Iterator<Integer> iterator = s.iterator();
		while (iterator.hasNext()) {
			StdOut.print(iterator.next() + " ");
			s.pop();
		}
		/*
		 	3 Exception in thread "main" java.util.ConcurrentModificationException
		 */
	}
}
