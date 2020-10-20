import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] storages = new int[n];
		
		for (int i = 0; i < n; ++i)
			storages[i] = sc.nextInt();
		sc.close();
		
		int[] dp = new int[n];
		
		dp[0] = storages[0];
		dp[1] = Math.max(storages[0], storages[1]);
		for (int i = 2; i < n; ++i)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + storages[i]);
		
		System.out.print(dp[n - 1]);
	}

}
