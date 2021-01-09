import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Integer[] moneyTypes = new Integer[n];
		
		for (int i = 0; i < n; ++i) {
			moneyTypes[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(moneyTypes, Collections.reverseOrder());
		
		int min = moneyTypes[n - 1];
		
		while (true) {
			int temp = min;
			
			for (int moneyType : moneyTypes) {
				if (temp >= moneyType) {
					temp -= moneyType;
				}
				
				if (temp == 0) {
					break;
				}
			}
			
			if (temp > 0) {
				break;
			}
			
			++min;
		}
		
		System.out.print(min);
	}

}
