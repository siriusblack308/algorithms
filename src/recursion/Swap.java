package recursion;

public class Swap {
	String s1 = "something";
	String s2 = "more";
	
	public String swap(String s1, String s2) {
		return s1;
		 
	}
	public static void main(String[] arg) {
		Swap swap = new Swap();
		 
		swap.s2 = swap.swap(swap.s1, swap.s1=swap.s2);
		System.out.println(swap.s1);
		System.out.println(swap.s2);
	}
}
