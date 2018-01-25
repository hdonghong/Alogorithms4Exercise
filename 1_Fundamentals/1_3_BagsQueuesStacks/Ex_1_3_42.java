/**
 * @ClassName	Ex_1_3_42	
 * @Description	强调一个新的独立的副本
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 17:09:24
 */
public class Ex_1_3_42<Item> {

	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		MyStack<Integer> t = new MyStack<>(s);
		for (Integer i : t) {
			System.out.print(i + " ");
		}
	}
}
