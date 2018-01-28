
/**
 * @ClassName	UF1
 * @Description	quick-find算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/28 07:37:49
 */
public class UF1 {

	private int[] id;	// 分量id
	private int count;	// 分量数量
	public UF1(int N) {
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
		return id[p];
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
		int pId = find(p);
		int qId = find(q);
		
		// p，q已经连通，停止继续执行
		if (pId == qId) return;
		
		// 连通p、q，将p的分量标识重命名为q的
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) id[i] = qId;
		}
		
		// 减少一个分量
		count--;
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		int N = StdIn.readInt();				// 读取触点数量
		UF1 uf = new UF1(N);					// 初始化N个分量
		
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
