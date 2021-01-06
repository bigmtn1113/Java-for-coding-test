import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] moneyTypes = new int[n];
		
		for (int i = 0; i < n; ++i) {
			moneyTypes[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(moneyTypes);
		
		int[] dp = new int[m + 1];
		
		Arrays.fill(dp, 1, m + 1, 10001);
		
		for (int i = moneyTypes[0]; i <= m; ++i) {
			for (int moneyType : moneyTypes) {
				if (i < moneyType) {
					break;
				}
				
				dp[i] = Math.min(dp[i], dp[i - moneyType] + 1);
			}
		}
		
		System.out.print((dp[m] != 10001) ? dp[m] : -1);
	}

}
