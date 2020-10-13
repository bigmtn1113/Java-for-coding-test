import java.util.Scanner;

public class Main {

	public static int binarySearch(int[] arr, int target, int begin, int end) {
		if (begin > end) return -1;
		
		int mid = (begin + end) / 2;
		
		if (arr[mid] == target) return mid;
		else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, end);
		else return binarySearch(arr, target, begin, mid - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = sc.nextInt();
		sc.close();
		
		int result = binarySearch(arr, target, 0, n - 1);
		System.out.print(result == -1 ? "원소가 존재하지 않습니다." : result + 1);
	}

}
