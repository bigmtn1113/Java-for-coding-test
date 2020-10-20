import java.util.Scanner;

public class Main {
	
	public static int n, m;
	public static int[] riceCake = new int[1000000];
	
	public static int parametricSearch(int begin, int end) {
		int mid;
		int result = -1;
		long sum;
		
		while (begin <= end) {
			mid = (begin + end) / 2;
			sum = 0;
			
			for (int i = 0; i < n; ++i)
				if (riceCake[i] > mid)
					sum += riceCake[i] - mid;
			
			if (sum >= m) { result = mid; begin = mid + 1; }
			else end =  mid - 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int max = 0;
		for (int i = 0; i < n; ++i) {
			riceCake[i] = sc.nextInt();
			max = Math.max(max, riceCake[i]);
		}
		sc.close();
		
		System.out.print(parametricSearch(0, max));
	}

}
