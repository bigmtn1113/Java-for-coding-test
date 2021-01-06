import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] storage = new int[n];
		
		for (int i = 0 ; i < n; ++i) {
			storage[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[n];
		
		dp[0] = storage[0];
		dp[1] = Math.max(storage[0], storage[1]);
		
		for (int i = 2; i < n; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + storage[i]);
		}
		
		System.out.print(dp[n - 1]);
	}

}
