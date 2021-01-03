import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] array = new int[1000001];
		
		for (int i = 0; i < n; ++i) {
			++array[sc.nextInt()];
		}
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			System.out.print((array[sc.nextInt()] > 0) ? "yes " : "no ");
		}
		sc.close();
	}

}
