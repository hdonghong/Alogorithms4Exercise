import java.util.Arrays;

/**
 * @ClassName	Quick	
 * @Description	
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/09 07:40:43
 */
public class Quick {

	public static void main(String[] args) {
		String[] a = new String[] {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int index = partition(a, lo, hi);
		sort(a, lo, index-1);
		sort(a, index+1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable v = a[i];
		a[i] = a[j];
		a[j] = v;
	}

	private static boolean less(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
	}
}
