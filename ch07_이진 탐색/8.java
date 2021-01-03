import java.util.Scanner;

public class Main {
	public static int[] riceCakes;
	
	public static int parametricSearch(int begin, int end, int target) {
		int result = -1;
		
		while (begin <= end) {
			int mid = (begin + end) / 2;
			long sum = 0;
			
			for (int riceCake : riceCakes) {
				if (riceCake > mid) {
					sum += riceCake - mid;
				}
			}
			
			if (sum >= target) {
				result = mid;
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		riceCakes = new int[n];
		int max = 0;
		
		for (int i = 0; i < n; ++i) {
			riceCakes[i] = sc.nextInt();
			
			max = Math.max(max, riceCakes[i]);
		}
		sc.close();
		
		System.out.print(parametricSearch(0, max, m));
	}

}
