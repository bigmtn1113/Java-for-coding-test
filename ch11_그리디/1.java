import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] fear = new int[n];
		
		for (int i = 0; i < n; ++i) {
			fear[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(fear);
		
		int groupCount = 0;
		
		for (int i = n - 1; i >= 0; --i) {
			if (n < fear[i]) {
				break;
			}
			
			n -= fear[i];
			i -= fear[i] - 1;
			
			++groupCount;
		}
		
		System.out.print(groupCount);
	}

}
