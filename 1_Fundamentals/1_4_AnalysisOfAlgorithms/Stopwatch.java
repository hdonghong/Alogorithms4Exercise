
/**
 * @ClassName	StopWatch	
 * @Description	一种表示计时器的抽象数据类型
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/24 23:58:21
 */
public class Stopwatch {

	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	/**
	 * 输出用时
	 * @return
	 */
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-1000000, 1000000);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		System.out.println(cnt + "triples " + time + " seconds");
	}
}
