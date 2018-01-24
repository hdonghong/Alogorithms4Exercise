
/**
 * @ClassName	Ex_1_4_04_Parentheses	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/24 09:22:26
 */
public class Ex_1_3_04_Parentheses {

	public static void main(String[] args) {
		String str = "[()]{}{[()()]{}}"; // 待检验的字符串
		boolean flag = true; // 结果标识，默认为真
		
		MyStack<Character> stack = new MyStack<>();
		for (int i = 0; i < str.length() && flag; i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
			} else {
				if (flag = !stack.isEmpty());
				else if (c == ']') flag = (stack.pop() == '[');
				else if (c == ')') flag = (stack.pop() == '(');
				else if (c == '}') flag = (stack.pop() == '{');
			}
		}
		
		System.out.println(flag);
	}
}
