
/**
 * @ClassName	UF4_PathCompressionWeightedQuiedUnion	
 * @Description	路径压缩加权quick-union算法
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/28 18:47:22
 */
public class UF4_PathCompressionWeightedQuiedUnion {

	private int[] id;
	private int[] sz;
	private int count;
	public UF4_PathCompressionWeightedQuiedUnion(int N) {
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int count() {return count;}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * find中进行路径压缩
	 * @param p
	 * @return
	 */
	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
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
}
