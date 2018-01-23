
/**
 * @ClassName:	Stats	
 * @Description:TODO
 * @author:		hdonghong
 * @version: 	v1.0 
 * @since:		2018/01/23 09:38:35
 */
public class Stats {

	public static void main(String[] args) {
		Bag<Double> numbers = new Bag<Double>();
		
		while (!StdIn.isEmpty()) {
			numbers.add(StdIn.readDouble());
		}
		int N = numbers.size();
		
		// 计算均值
		double sum = 0.0;
		for (Double x : numbers) {
			sum += x;
		}
		double mean = sum / N;
		
		// 计算标准差
		sum = 0.0;
		for (Double x : numbers) {
			sum += (x - mean) * (x - mean);
		}
		double std = Math.sqrt(sum / (N-1));
		
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}
