
/**
 * @ClassName	UF3_WeightedQuickUnionUF	
 * @Description	加权quick-union算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/28 10:12:11
 */
public class UF3_WeightedQuickUnionUF {

	private int[] id;
	private int[] sz; // 记录一棵树的节点数
	private int count;// 连通分量
	public UF3_WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	
	public void union(int p, int q) {
		int pRoot = find(p); // 找到整数对的父节点
		int qRoot = find(q);
		
		if (pRoot == qRoot) return; // 整数对已经连接，停止继续执行
		
		if (sz[pRoot] < sz[qRoot]) {// 小树根节点加到大树根节点上
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		
		count--; //减少一个连通分量
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();				// 读取触点数量
		UF3_WeightedQuickUnionUF uf 
			= new UF3_WeightedQuickUnionUF(N);	// 初始化N个分量
		
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
