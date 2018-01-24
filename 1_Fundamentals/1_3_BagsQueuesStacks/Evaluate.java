
/**
 * @ClassName	Evaluate	
 * @Description	双栈算术表达式求值算法，以空格分隔
 * 				限定操作符 + - * / sqrt
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/23 10:04:44
 */
public class Evaluate {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		
		while (!StdIn.isEmpty()) {
			String str = StdIn.readString();
			if (str.equals("("));
			else if (str.equals("+")) ops.push(str);
			else if (str.equals("-")) ops.push(str);
			else if (str.equals("*")) ops.push(str);
			else if (str.equals("/")) ops.push(str);
			else if (str.equals("sqrt")) ops.push(str);
			else if (str.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v = vals.pop() * v;
				else if (op.equals("/")) v = vals.pop() / v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else { // 剩下的是数字部分，包含小数点
				vals.push(Double.parseDouble(str));
			}
		}
		System.out.println(vals.pop());
	}
}
