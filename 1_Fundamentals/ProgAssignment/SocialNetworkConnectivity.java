import java.io.FileInputStream;

/**
 * @ClassName	SocialNetworkConnectivity	
 * @Description	Given a social network containing n members and a log file containing  timestamps 
 * 				at which times pairs of members formed friendships, design an algorithm to determine 
 * 				the earliest time at which all members are connected (i.e., every member is a friend 
 * 				of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp 
 * 				and that friendship is an equivalence relation. The running time of your algorithm 
 * 				should be mlogn or better and use extra space proportional to n.
 * 				题目的意思是有一个包含n个成员的社交网络，日志文件log按照时间戳顺序存储了两个成员之间成为朋友的时间，共有m条记录。
 * 				让我们设计一个算法来根据这个log文件来计算m个成员全部通过朋友关系连通的时间。
 * 				典型的并查集。思路是读取日志文件，遍历文件记录，逐条记录union。采用加权quick-union算法，就可以满足mlogn的复杂度要求
 * @author		hdonghong
 * @version 	v1.0 
 * @since		2018/01/28 19:46:16
 */
public class SocialNetworkConnectivity {

	private FileInputStream ins;
}
