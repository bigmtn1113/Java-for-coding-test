public class Main {

	public static long[] mem = new long[100];
	
	public static long fibonachi(int x) {
		System.out.print("f(" + x + ") ");
    
		if (x == 1 || x == 2) return 1;
		if (mem[x] != 0) return mem[x];
		
		return mem[x] = fibonachi(x - 1) + fibonachi(x - 2);
	}
	
	public static void main(String[] args) {
		fibonachi(6);
	}

}
