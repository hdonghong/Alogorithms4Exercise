
/**
 * @ClassName	UF1
 * @Description	quick-union算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/28 07:37:49
 */
public class UF2 {

	private int[] id;	// 分量id
	private int count;	// 分量数量
	public UF2(int N) {
		// 初始化N个连通分量的id数组
		count  = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/**
	 * 返回连通分量的数量
	 * @return
	 */
	public int count() { return count; }
	
	/**
	 * 获取p所在分量的标识符，标识符为分量中某个触点的名称
	 * @param p
	 * @return
	 */
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * 判断p和q两个触点是否连通，即是否属于同一个分量
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * 在p，q间增加一条连接
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		// p，q已经连通，停止继续执行
		if (pRoot == qRoot) return;
		
		// 连通p，q
		id[pRoot] = qRoot;
		
		// 减少一个分量
		count--;
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		int N = StdIn.readInt();				// 读取触点数量
		UF2 uf = new UF2(N);					// 初始化N个分量
		
		Stopwatch timeCounter = new Stopwatch();// 计时器，开始计时
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();			// 读取整数对
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;	// 如果已经连通则忽略
			uf.union(p, q);						// 连通归并分量
			StdOut.println(p + " " + q); 		// 打印新连接
		}
		StdOut.println("用时" + timeCounter.elapsedTime() + "s");
		StdOut.println(uf.count() + "个连通分量");
	}
}
