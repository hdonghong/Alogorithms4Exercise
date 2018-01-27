
/**
 * @ClassName	Ex_1_4_19	
 * @Description	N*N矩阵的局部最小元素
 * 				同二分查找的思想，将矩阵进行切割。不保证答案一定正确
 * 				结果输出下标
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/26 16:35:53
 */
public class Ex_1_4_19 {

	public static void main(String[] args) {
		int[][] a = {
				{7650,2671,2766,43,2862,8723,9741,7535,778,2319},
				{3035,2196,1842,288,115,9040,8942,9267,2654,7452},
				{3811,5893,6729,4376,5353,5009,1110,4399,3548,9632},
				{2626,4090,9957,8759,1843,4966,7376,3934,6314,6947},
				{2448,4632,1326,5537,1544,6121,2082,2935,6544,4833},
				{1124,4639,9664,2710,9930,3980,2306,1682,2392,5021},
				{8751,6930,9075,6270,5829,6783,5576,5097,6515,3992},
				{3293,9161,8639,2361,4773,3661,5577,4031,2055,7356},
				{1150,6944,1730,3969,3430,1116,200,8010,1340,5460},
				{2290,7759,386,4948,8909,2218,9758,4227,8591,6422}};
		System.out.println(getLocalMin(a));
	}
	
	public static String getLocalMin(int[][] arr) {
		int rowN = arr.length;	// rowN排
		int colN = rowN;		// 因为是N*N数组
		if ( rowN == 1 ) return null;
		// 处理边界元素的情况
		else if (isLocalMin(arr[0][0], arr[0][1], arr[1][0])) return "0 0";
		else if (isLocalMin(arr[0][colN-1], arr[0][colN-2], arr[1][colN-1])) return "0 " + colN;
		else if (isLocalMin(arr[rowN-1][0], arr[rowN-2][0], arr[rowN-1][1])) return rowN-1 + " 0";
		else if (isLocalMin(arr[rowN-1][colN-1], arr[rowN-1][colN-2], arr[rowN-2][colN-1])) return (rowN-1) + " " + (colN-1);
		else {
			int left = 0;
			int right = colN - 1;
			int top = 0;
			int bottom = rowN - 1;
			int rowMid = (left + right) / 2;
			int colMid = (top + bottom) / 2;
			
			while (rowMid > top || rowMid < bottom || colMid > left || colMid < right) {
				if (rowMid > top && arr[rowMid-1][colMid] < arr[rowMid][colMid]) {			 // 竖着切去下半部分矩阵[rowMid+1, colmid] ~ [bottom, colmid]
					bottom = rowMid;
					rowMid = (top + bottom) / 2;
				} else if (rowMid < bottom && arr[rowMid+1][colMid] < arr[rowMid][colMid]) { // 竖着切去上半部分矩阵
					top = rowMid;
					rowMid = (top + bottom + 1) / 2;
				} else if (colMid > left && arr[rowMid][colMid-1] < arr[rowMid][colMid]) {   // 横着切去右半部分矩阵 [rowmid, colmid+1] ~ [rowmid, right]
					right = colMid;
					colMid = (left + right) / 2;
				} else if (colMid < right && arr[rowMid][colMid+1] < arr[rowMid][colMid]) {	 // 横着切去左半部分矩阵
					left = colMid + 1;
					colMid = (left + right + 1) / 2;
				} else { // 中间值为局部最小
					return rowMid + " " + colMid;
				}
			}
		}
		return "";
	}
	
	/**
	 * 判断传进来的数组首元素是否为最小
	 * @return
	 */
	public static boolean isLocalMin(int ... arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[0] > arr[i]) return false;
		}
		return true;
	}
}
