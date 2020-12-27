import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int max = 0;
		for (int i = 0; i < n; ++i) {
			int min = sc.nextInt();
			
			for (int j = 1; j < m; ++j) {
				int temp = sc.nextInt();
				
				if (min > temp) {
					min = temp;
				}
			}
			
			if (max < min) {
				max = min;
			}
		}
		sc.close();
		
		System.out.print(max);
	}

}
