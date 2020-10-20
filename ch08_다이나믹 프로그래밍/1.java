public class Main {

	public static int fibonachi(int x) {
		if (x == 1 || x == 2) return 1;
		
		return fibonachi(x - 1) + fibonachi(x - 2);
	}
	
	public static void main(String[] args) {
		System.out.print(fibonachi(4));
	}

}
