
/**
 * @ClassName	Ex_2_2_11	
 * @Description	加快小数组的排序速度，检测数组是否已经有序以及通过在递归中交换参数来避免数组复制
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/07 12:17:37
 */
public class Ex_2_2_11 {

	private static boolean less(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
	}
	private static void merge(Comparable[] src, Comparable[] des, int lo, int mid, int hi) {
		int i = lo;
		int j = hi;
		for (int k = i; k <= hi; k++) {
			if (i > mid) des[k] = src[j++];
			else if (j > hi) des[k] = src[i++];
			else if (less(src[j], src[i])) des[k] = src[j++];
			else des[k] = src[i++];
		}
	}
}
