
public class Ex_1_1_07 {
	
	public static void main(String[] args) {
		double t = 9.0;
		while (Math.abs(t - 9.0)/t > 0.001) 
			t = (9.0/t + t) / 2.0;
		StdOut.printf("%.5f  ", t);
		/*
		  9.00000  
		 */
		
	}
}
