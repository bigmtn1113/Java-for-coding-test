import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] balls = new int[n];
		int[] ballCounts = new int[m + 1];
		
		for (int i = 0; i < n; ++i) {
			balls[i] = sc.nextInt();
			
			++ballCounts[balls[i]];
		}
		sc.close();
		
		int count = 0;
		
		for (int i = 1; i <= m; ++i) {
			n -= ballCounts[i];
			count += n * ballCounts[i];
		}
		
		System.out.print(count);
	}

}
