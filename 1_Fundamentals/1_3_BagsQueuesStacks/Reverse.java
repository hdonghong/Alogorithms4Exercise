
/**
 * @ClassName:	Reverse	
 * @Description:TODO
 * @author:		hdonghong
 * @version: 	v1.0 
 * @since:		2018/01/23 09:49:18
 */
public class Reverse {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		while (!StdIn.isEmpty()) {
			stack.push(StdIn.readInt());
		}
		
		for (int i : stack) {
			StdOut.println(i);
		}
	}
}
