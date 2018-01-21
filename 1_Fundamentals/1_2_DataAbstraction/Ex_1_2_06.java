
/**
 * @ClassName:	Ex_1_2_06	
 * @Description:TODO
 * @author:		hdonghong
 * @version: 	v1.0 
 * @since:		2018/01/20 17:31:14
 */
public class Ex_1_2_06 {

	public static void main(String[] args) {
		String s = "ACTGACG";
		String t = "TGACGAC";
		
		System.out.println(isCircularRotn(s, t));
	}
	
	public static boolean  isCircularRotn(String s, String t) {
		return (s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0);
	}
}
