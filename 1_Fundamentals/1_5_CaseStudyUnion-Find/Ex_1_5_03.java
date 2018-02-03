import java.util.Arrays;

/**
 * @ClassName	Ex_1_5_03	
 * @Description	使用加权quick-union算法，对于输入的每一对整数，给出id[]数组的内容和访问数组的次数
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/02/03 09:03:33
 */
public class Ex_1_5_03 {
	private int[] id;
	private int count;
	private int[] sz;
	
	private int accessTimes = 0;// 对每对整数记录对数组的访问次数
	public Ex_1_5_03(int n) {
		count = n;
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count() { return count; }
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
			accessTimes += 2;
		}
		return p;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public void union(int p, int q) {
		accessTimes = 0;
		int pId = find(p);
		int qId = find(q);
		if (pId == qId) {
			System.out.println(p + " " + q + "已经相连，当前id[]：" + Arrays.toString(id) + "数组访问次数：" + accessTimes);
			return;
		}
		
		if (sz[pId] > sz[qId]) {
			sz[pId] += sz[qId];
			id[qId] = pId;
		} else {
			sz[qId] += sz[pId];
			id[pId] = qId;
		}
		accessTimes += 3;
		System.out.println("当前id[]：" + Arrays.toString(id) + "数组访问次数：" + accessTimes);
		count--;
	}
	
	
	public static void main(String[] args) {
		int N = StdIn.readInt();				// 读取触点数量
		Ex_1_5_03 uf = new Ex_1_5_03(N);		// 初始化N个分量
		
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();			// 读取整数对
			int q = StdIn.readInt();
			uf.union(p, q);						// 连通归并分量
		}
		
		/*
		 	10
			9 0
			当前id[]：[0, 1, 2, 3, 4, 5, 6, 7, 8, 0]数组访问次数：3
			3 4
			当前id[]：[0, 1, 2, 4, 4, 5, 6, 7, 8, 0]数组访问次数：3
			5 8
			当前id[]：[0, 1, 2, 4, 4, 8, 6, 7, 8, 0]数组访问次数：3
			7 2
			当前id[]：[0, 1, 2, 4, 4, 8, 6, 2, 8, 0]数组访问次数：3
			2 1
			当前id[]：[0, 2, 2, 4, 4, 8, 6, 2, 8, 0]数组访问次数：3
			5 7
			当前id[]：[0, 2, 2, 4, 4, 8, 6, 2, 2, 0]数组访问次数：7
			0 3
			当前id[]：[4, 2, 2, 4, 4, 8, 6, 2, 2, 0]数组访问次数：5
			4 2
			当前id[]：[4, 2, 2, 4, 2, 8, 6, 2, 2, 0]数组访问次数：3
		 */
	}
}
