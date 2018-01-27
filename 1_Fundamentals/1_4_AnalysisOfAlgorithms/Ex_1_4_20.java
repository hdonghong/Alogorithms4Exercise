import java.util.Arrays;

/**
 * @ClassName	Ex_1_4_20	
 * @Description	双调查找
 * 				将数组从中间分开，一边是单调数组，进行二分查找；另一边不确定，递归处理。
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/26 17:02:32
 */
public class Ex_1_4_20 {

	public static void main(String[] args) {
		int[] a = {-1, 0, 1, 4, -3, -5, -6};
		System.out.println(bitonicSearch(-2, a));
	}
	
	public static boolean bitonicSearch(int key, int[] a) {
		boolean result = false;
		int mid = a.length / 2;
		if (mid > 0) {
			if (a[mid] > a[mid-1]) { // 左边是单调递增数组，右边是双调数组
				result = BinarySearch.rank(key, Arrays.copyOf(a, mid+1)) != -1;
				 // 左边找不到目标值
				if (!result) return bitonicSearch(key, Arrays.copyOfRange(a, mid+1, a.length));
			} else { // 左边是双调数组，右边是单调递减数组
				int[] temp = Arrays.copyOfRange(a, mid, a.length);
				Arrays.sort(temp);
				result = BinarySearch.rank(key, temp) != -1;
				// 右边找不到目标值
				if (!result) return bitonicSearch(key, Arrays.copyOf(a, mid));
			}
		}
		return result;
	}
}
