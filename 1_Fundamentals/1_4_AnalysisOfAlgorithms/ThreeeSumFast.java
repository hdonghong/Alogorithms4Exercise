import java.util.Arrays;

/**
 * @ClassName	ThreeeSumFast	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 13:03:09
 */
public class ThreeeSumFast {

	public static int count(int[] a) {
		// 计算和为0的三元组的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (BinarySearch.rank(-a[i]-a[j], a) > j)
					cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}
