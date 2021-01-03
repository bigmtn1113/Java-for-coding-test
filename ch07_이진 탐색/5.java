import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] array;
	
	public static boolean binarySearch(int begin, int end, int target) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (target == array[mid]) {
				return true;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		Arrays.sort(array);
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			boolean hasNum = binarySearch(0, n - 1, sc.nextInt());
			
			System.out.print((hasNum == true) ? "yes " : "no ");
		}
		sc.close();
	}

}
