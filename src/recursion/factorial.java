package recursion;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new factorial()).findFactorial(5));
		System.out.println((new factorial()).fabonaci(10));
	}
	public int findFactorial(int num) {
		
		if (num == 0) {
			return 1;
		}
		return num * findFactorial(num -1);
	}
	public int fabonaci(int num) {
		
		if(num <= 1) {
			return num;
		}
			
		
		return fabonaci(num -1) + fabonaci(num -2 );
	}
}
