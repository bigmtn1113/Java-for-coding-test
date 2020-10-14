import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int binarySearch(int[] arr, int target, int begin, int end) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
		
			if (arr[mid] == target) return mid;
			else if (arr[mid] < target) begin = mid + 1;
			else end = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int data[] = new int[n];
		for (int i = 0; i < n; ++i)
			data[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int target[] = new int[m];
		for (int i = 0; i < m; ++i)
			target[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(data);
		
		for (int i = 0; i < m; ++i) {
			int result = binarySearch(data, target[i], 0, n - 1);
			System.out.print(result == -1 ? "no " : "yes ");
		}
	}

}
