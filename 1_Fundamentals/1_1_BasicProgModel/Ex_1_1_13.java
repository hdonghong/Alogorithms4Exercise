
public class Ex_1_1_13 {

	public static void main(String args[]) {
		int m = 3;
		int n = 4;
		
		// 初始化二维数组
		int[][] twoDArrs = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				twoDArrs[i][j] = j + (m + 1) * i;
				System.out.print(twoDArrs[i][j] + " ");
			}
			System.out.println("");
		}
		/*
		 	0 1 2 3 
			4 5 6 7 
			8 9 10 11 
		 */
		
		System.out.println("");
		// 转置
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				System.out.print(twoDArrs[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 	0 4 8 
			1 5 9 
			2 6 10 
			3 7 11 
		 */
	}
}
