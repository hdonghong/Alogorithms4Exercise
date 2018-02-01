
/**
 * @ClassName	Example	
 * @Description	排序算法类的模板
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/01 21:02:10
 */
@SuppressWarnings("all")
public class Example {

	public static <T> void sort(Comparable<T>[] a) {
		
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
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	/**
	 * 测试用例
	 */
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		StdOut.println(isSorted(a));
		show(a);
	}
}
