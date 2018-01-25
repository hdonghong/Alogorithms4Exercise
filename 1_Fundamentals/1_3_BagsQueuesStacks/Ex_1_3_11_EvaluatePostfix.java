
/**
 * @ClassName	Ex_1_3_11_EvaluatePostfix	
 * @Description	计算后序表达式的值
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 13:24:03
 */
public class Ex_1_3_11_EvaluatePostfix {

	public static double evaluatePostfix(String postfix) {
		String[] ops = postfix.trim().split(" ");
		MyStack<Double> stack = new MyStack<>();
		for (int i = 0; i < ops.length; i++) {
			String op = ops[i];
			if (op.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (op.equals("-")) {
				stack.push(-(stack.pop() - stack.pop()));
			} else if (op.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (op.equals("/")) {
				stack.push(1/stack.pop() * stack.pop());
			} else {
				stack.push(Double.parseDouble(op));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String postfix = Ex_1_3_10_InfixToPostfix.infixToPostfix("( 1 + ( ( 3 + 2 ) * ( 4 / 3 ) ) )");
		System.out.println(evaluatePostfix(postfix));	// 7.666666666666666
	}
}
