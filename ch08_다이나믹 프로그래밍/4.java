public class Main {
	
	public static void main(String[] args) {
		long[] mem = new long[100];
		
		mem[1] = 1;
		mem[2] = 1;
		
		for (int i = 3; i <= 50; ++i) {
			mem[i] = mem[i - 1] + mem[i - 2];
		}
		
		System.out.print(mem[50]);
	}

}
