
/**
 * @ClassName	Shell	
 * @Description	希尔排序算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/02 07:25:15
 */
public class Shell {

	public static <T> void sort(Comparable<T>[] a) {
		int n = a.length;
		int h = 1;
		while (h < n/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093...
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			h /= 3;
		}
	}
	
	public static <T> void originalSort(Comparable<T>[] a) {
		int n = a.length;
		for (int h = n / 2; h > 0; h /= 2) {
			// 进行插入排序
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * 交换数组中两个元素的位置
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * 在单行中打印数组
	 * @param a
	 */
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	/**
	 * 测试数组元素是否有序
	 * @param a
	 * @return
	 */
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	/**
	 * 测试用例
	 */
	public static void main(String[] args) {
//		String[] a = In.readStrings();
		String[] a =  {  "S" , "H" , "E" , "L" , "L" , "S" , "O" , "R" , "T" , "E" , "X" , "A" , "M" , "P" , "L" , "E" } ;
		sort(a);
		StdOut.println(isSorted(a));
		show(a);
	}
}
