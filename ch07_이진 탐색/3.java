import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] array;

	public static int binarySearch(int begin, int end, int target) {
		while (begin <= end) {
			int mid = (begin + end) / 2;
			
			if (target == array[mid]) {
				return mid + 1;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(array);
		
		int result = binarySearch(0, n - 1, target);
		
		System.out.print((result != -1) ? result : "원소가 존재하지 않습니다.");
	}

}
