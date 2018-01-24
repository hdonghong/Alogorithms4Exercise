
/**
 * @ClassName	Ex_1_3_10	
 * @Description	简单的中序表达式转换为后序表达式，中序表达式中操作数与操作符通过空格号分隔
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/24 09:56:48
 */
public class Ex_1_3_10_InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(infixToPostfix("( 1 + ( ( 3 + 2 ) * ( 4 / 3 ) ) )"));
		/*
		 * result:  1 3 2 + 4 3 / * +
		 */
	}
	
	public static String infixToPostfix(String expression) {
		String[] ops = expression.split(" ");
		String result = "";
		MyStack<String> stack = new MyStack<>();
		
		for (int i = 0; i < ops.length; i++) {
			String op = ops[i];
			if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				stack.push(op);
			} else if (op.equals(")")) {
				result += (" " + stack.pop());
			} else if (op.equals("(")) {
			} else {
				result += (" " + op);
			}
		}
		
		return result;
	}
}
