
public class Ex_1_1_14 {

	public static int lg(int n) {
		int sum = 2;
		int count = 0;
		if (n > 1)
			do count++;
			while ((sum <<= 1) <= n);
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(lg(1));
		System.out.println(lg(2));
		
		System.out.println(lg(7));
		System.out.println(lg(8));
		
		System.out.println(lg(16));
		System.out.println(lg(17));
		
		System.out.println(lg(32));
		System.out.println(lg(33));
		
		System.out.println(lg(128));
		System.out.println(lg(256));
		
	}
}
