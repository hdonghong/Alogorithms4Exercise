
/**
 * @ClassName	ThreeSum	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/24 23:55:07
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
	
	public static int count(int[] a) {
		// 统计和为0的元祖的数量
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
				}
			}
		}
		return cnt;
	}
}
