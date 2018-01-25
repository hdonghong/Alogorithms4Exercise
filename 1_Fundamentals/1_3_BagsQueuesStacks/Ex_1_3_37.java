
/**
 * @ClassName	Ex_1_3_37	
 * @Description	约瑟夫问题
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/25 16:15:27
 */
public class Ex_1_3_37 {

	public static void main(String[] args) {
		solveJosephusProb(7, 2);
	}
	
	/**
	 * 解决约瑟夫问题
	 * @param N 总数
	 * @param M 第M个
	 */
	public static void solveJosephusProb(int N, int M) {
		Queue<Integer> queue = new Queue<>();
		for (int i = 0; i < N; queue.enqueue(i++));
		while (!queue.isEmpty()) {
			for (int i = 0; i < M-1; i++)
				queue.enqueue(queue.dequeue());
			System.out.print(queue.dequeue() + " ");
		}
	}
}
