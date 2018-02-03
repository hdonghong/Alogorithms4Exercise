import java.util.Arrays;

/**
 * @ClassName	Ex_1_5_01	
 * @Description	使用quick-find算法，对于输入的每一对整数，给出id[]数组的内容和访问数组的次数
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/02 23:21:13
 */
public class Ex_1_5_01 {

	private int[] id;
	private int count;
	public Ex_1_5_01(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	public int count() { return count; }
	public int find(int p) {
		return id[p];
	}
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	public void union(int p, int q) {
		int accessTimes = 0;// 对每对整数记录对数组的访问次数
		
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			System.out.println(p + " " + q + "已经相连，当前id[]：" + Arrays.toString(id) + "数组访问次数：" + accessTimes);
			return;
		}
		for (int i = 0; i < id.length; i++,accessTimes++) {
			if (id[i] == pId) { 
				id[i] = qId;
				accessTimes++;
			}
		}
		System.out.println("当前id[]：" + Arrays.toString(id) + "数组访问次数：" + accessTimes);
		count--;
	}
	
	
	public static void main(String[] args) {
		int N = StdIn.readInt();				// 读取触点数量
		Ex_1_5_01 uf = new Ex_1_5_01(N);		// 初始化N个分量
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();			// 读取整数对
			int q = StdIn.readInt();
			uf.union(p, q);						// 连通归并分量
		}
		
		/*
		 	10
			9 0
			当前id[]：[0, 1, 2, 3, 4, 5, 6, 7, 8, 0]数组访问次数：11
			3 4
			当前id[]：[0, 1, 2, 4, 4, 5, 6, 7, 8, 0]数组访问次数：11
			5 8
			当前id[]：[0, 1, 2, 4, 4, 8, 6, 7, 8, 0]数组访问次数：11
			7 2
			当前id[]：[0, 1, 2, 4, 4, 8, 6, 2, 8, 0]数组访问次数：11
			2 1
			当前id[]：[0, 1, 1, 4, 4, 8, 6, 1, 8, 0]数组访问次数：12
			5 7
			当前id[]：[0, 1, 1, 4, 4, 1, 6, 1, 1, 0]数组访问次数：12
			0 3
			当前id[]：[4, 1, 1, 4, 4, 1, 6, 1, 1, 4]数组访问次数：12
			4 2
			当前id[]：[1, 1, 1, 1, 1, 1, 6, 1, 1, 1]数组访问次数：14
		 */
	}
}
