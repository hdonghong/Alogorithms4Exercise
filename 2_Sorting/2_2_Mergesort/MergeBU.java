
/**
 * @ClassName	MergeBU	
 * @Description	自底向上的归并排序算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/06 22:15:32
 */
public class MergeBU {

	private static Comparable[] temp;// 排序时用到的临时数组
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = hi;
		for (int k = lo; k <= hi; k++) {
			temp[k] = a[lo];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) a[k] = temp[j++];
			else if (j > hi) a[k] = temp[i++];
			else if (less(temp[j], temp[i])) a[k] = temp[j++];
			else a[k] = temp[i++];
		}
	}
	
	public static void sort(Comparable[] a) {
		// 进行lgN次两两归并
		int N = a.length;
		temp = new Comparable[N];
		for (int subArrCapacity = 1; subArrCapacity < N; subArrCapacity += subArrCapacity) {// subArrCapacity
			for (int lo = 0; lo < N-subArrCapacity; lo += subArrCapacity+subArrCapacity) {
				merge(a, lo, lo+subArrCapacity-1, Math.min(lo+subArrCapacity+subArrCapacity-1, N-1));
			}
		}
	}
	
	public static void main(String[] args) {
		int j = 3;
		int i = (int) Math.pow(10, j++);
		System.out.println(i+"<"+j);
	}
}
