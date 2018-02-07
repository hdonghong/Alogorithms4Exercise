import java.util.Arrays;

/**
 * @ClassName	Merge	
 * @Description	自顶向下的归并排序，NlgN
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/05 20:12:52
 */
public class Merge<T> {
	private static Comparable[] temp;

	/**
	 * 归并排序
	 * @param <T>
	 * @param a
	 */
	public static <T> void sort(Comparable<T>[] a) {
		temp = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	private static <T> void sort(Comparable<T>[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);//分
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);//治
	}
	
	/**
	 * 归并两个有序数组
	 * @param <T>
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static <T> void merge(Comparable<T>[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		System.arraycopy(a, lo, temp, lo, hi-lo+1);
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = temp[j++];
			else if (j > hi) a[k] = temp[i++];
			else if (less(temp[j], temp[i])) a[k] = temp[j++];
			else a[k] = temp[i++];
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	
	
	public static void main(String[] args) {
		String[] a = new String[] {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		System.err.println(Arrays.toString(a));
	}
}
