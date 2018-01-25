
/**
 * @ClassName	DoublingTest	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 12:36:01
 */
public class DoublingTest {

	public static double timeTrial(int N) {
		// 为处理N个随机的六位整数的ThreeSum.count
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		// 打印运行时间的表格
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}
}
