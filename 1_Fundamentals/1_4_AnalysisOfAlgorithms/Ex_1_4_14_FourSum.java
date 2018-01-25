import java.util.Arrays;

/**
 * @ClassName	Ex_1_4_14_FourSum	
 * @Description	为4-sum设计算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 23:49:34
 */
public class Ex_1_4_14_FourSum {

	public static void main(String[] args) {
		
	}
	
	public static int count(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) 
			for (int j = i+1; j < N; j++) 
				for (int k = j+1; k < N; k++)
					if (BinarySearch.rank(-a[i]-a[j]-a[k], a) > k)
						cnt++;
		
		return cnt;
	}
}
