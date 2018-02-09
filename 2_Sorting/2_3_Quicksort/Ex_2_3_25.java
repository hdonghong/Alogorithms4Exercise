import java.util.Arrays;

/**
 * @ClassName	Ex_2_3_25	
 * @Description	切换到插入排序，通常取M在5~15之间
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/09 08:21:25
 */
public class Ex_2_3_25 {

	private static final int M = 5;

	public static void main(String[] args) {
		String[] a = new String[] {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable v = a[i];
		a[i] = a[j];
		a[j] = v;
	}

	private static boolean less(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo + M) {// 使用插入排序
			for (int i = lo+1; i <= hi; i++) {
				for (int j = i; j > lo && less(a[j], a[j-1]); j--)
					exch(a, j, j-1);
			}
			return;
		}
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
}
