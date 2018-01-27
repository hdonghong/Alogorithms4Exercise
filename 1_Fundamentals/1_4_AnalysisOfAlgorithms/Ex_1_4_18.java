import java.util.Arrays;

/**
 * @ClassName	Ex_1_4_18	
 * @Description	数组的局部最小值，前提：数组不存在等值元素
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/26 15:50:31
 */
public class Ex_1_4_18 {

	public static void main(String[] args) {
		int[] nums = { -3, -4, -2, -1, 4, 3, 1, 2 };
		System.out.println(findLocalMin(nums));
	}
	
	public static int findLocalMin(int[] arr) {
		int N = arr.length;
		// 只有一个元素，无法进行判断
		if (N == 1) return -1;
		// 先处理边界的情况
		else if (arr[0] < arr[1]) return 0;
		else if (arr[N-1] < arr[N-2]) return N-1;
		// 普遍情况，判断除边界外的元素
		else {
			int left = 0;
			int right = N-1;
			int mid = (left + right) / 2;
			while (left < right) {
				if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) { // 中间数最小
					return mid;
				} else {
					if (arr[mid-1] < arr[mid]) {
						right = mid;
					} else {
						left = mid;
					}
					mid = (left + right) / 2;
				}
			}
		}
		
		return -1;
	}
}
