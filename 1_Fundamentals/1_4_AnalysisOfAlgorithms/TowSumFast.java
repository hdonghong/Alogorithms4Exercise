import java.util.Arrays;

/**
 * @ClassName	TowSumFast	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 12:59:09
 */
public class TowSumFast {

	public static int count(int[] a) {
		// 计算和为0的整数的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (BinarySearch.rank(-a[i], a) > i)
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}
