import java.util.Arrays;

/**
 * @ClassName	Ex_2_2_08	
 * @Description	证明a[mid] <= a[mid+1]时不用调用merge方法，处理有序数组即可为线性级别
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/07 11:35:57
 */
public class Ex_2_2_08 {

	private static Comparable[] temp;
	
	private static boolean less(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid+1;
		System.arraycopy(a, lo, temp, lo, hi-lo+1);
		for (int k = lo; k <=hi; k++) {
			if (i > mid) a[k] = temp[j++];
			else if (j > hi) a[k] = temp[i++];
			else if (less(temp[j],temp[i])) a[k] = temp[j++];
			else a[k] = temp[i++];
		}
	}
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		if (less(a[mid+1],a[mid])) merge(a, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		temp = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		String[] a = new String[] {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
