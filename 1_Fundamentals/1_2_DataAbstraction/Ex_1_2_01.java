
public class Ex_1_2_01 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Point2D[] point2ds = new Point2D[N];
		
		// 画点
		for (int i = 0; i < N; i++) {
			point2ds[i] = new Point2D(Math.random(), Math.random());
			point2ds[i].draw();
		}
		
		// 计算点距
		if (N > 1) {
			double min = point2ds[0].distanceTo(point2ds[1]);
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double temp = point2ds[i].distanceTo(point2ds[j]);
					if (temp < min) {
						min = temp;
					}
				}
			}
			System.out.println("the minium distance: " + min);
		}
	}
}
