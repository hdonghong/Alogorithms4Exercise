
/**
 * @ClassName:	Ex_1_2_16	
 * @Description:为有理数实现一个不可变数据类型
 * @author:		hdonghong
 * @version: 	v1.0 
 * @since:		2018/01/20 18:01:48
 */
public class Ex_1_2_16 {

	private final long numerator;
	private final long denominator;
	
	public Ex_1_2_16(long numerator, long denominator) {
		long maxCommonFactor = getMaxComFactor(numerator, denominator);
		this.numerator = numerator / maxCommonFactor;
		this.denominator = denominator == 0 ? // 分母为0时，处理为1
				1 : denominator / maxCommonFactor;
	}
	
	/**
	 * 获取最大公因数
	 * @param la
	 * @param lb
	 * @return
	 */
	private static long getMaxComFactor(long la, long lb) {
		while (lb != 0) {
			long temp = la % lb;
			la = lb;
			lb = temp;
		}
		return la;
	}
	
	public Ex_1_2_16 plus(Ex_1_2_16 b) {
		return new Ex_1_2_16(this.numerator*b.denominator + this.denominator*b.numerator, 
				this.denominator*b.denominator);
	}
	
	public Ex_1_2_16 minus(Ex_1_2_16 b) {
		return new Ex_1_2_16(this.numerator*b.denominator - this.denominator*b.numerator, 
				this.denominator*b.denominator);
	}
	
	public Ex_1_2_16 times(Ex_1_2_16 b) {
		return new Ex_1_2_16(this.numerator*b.numerator, this.denominator*b.denominator);
	}
	
	public Ex_1_2_16 divides(Ex_1_2_16 b) {
		return new Ex_1_2_16(this.numerator*b.denominator, this.denominator*b.numerator);
	}
	
	public boolean equals(Ex_1_2_16 that) {
		return this.numerator == that.numerator && this.denominator ==that.denominator;
	}
	
	@Override
	public String toString() {
		return this.denominator == 1 || this.numerator == 0 ?
				this.numerator+"" : this.numerator+"/"+this.denominator;
	}
	
	public static void main(String[] args) {
		Ex_1_2_16 t1 = new Ex_1_2_16(6, 2);
		Ex_1_2_16 t2 = new Ex_1_2_16(3, 4);
		
		System.out.println(t1);
		System.out.println(t1.plus(t2));
		System.out.println(t2.minus(t1));
		System.out.println(t1.times(t2));
		System.out.println(t1.divides(t2));
		System.out.println(t1.equals(new Ex_1_2_16(9, 3)));
		
		/* 	result:
		 	3
			15/4
			9/-4
			9/4
			4
			true
		 */
	}
}
