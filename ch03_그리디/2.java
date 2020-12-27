import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[1001];
		
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr, 0, n);
		
		int sum = 0;
		sum += ((arr[n - 1] * k) + arr[n - 2]) * (m / (k + 1)) + (arr[n - 1] * (m % (k + 1)));
		
		System.out.print(sum);
	}
}
