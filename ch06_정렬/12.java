import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; ++i)
			a[i] = sc.nextInt();
		for (int i = 0; i < n; ++i)
			b[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int reverseI = n - 1;
		for (int i = 0; i < k; ++i) {
			if (a[i] < b[reverseI - i]) {
				int temp = a[i];
				a[i] = b[reverseI - i];
				b[reverseI - i] = temp;
			} else break;
		}
		
		long sum = 0;
		for (int i : a)
			sum += i;
		System.out.print(sum);
	}

}
