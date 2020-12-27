import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		int[] coinTypes = {500, 100, 50, 10};
		
		for (int coin : coinTypes) {
			cnt += n / coin;
			n %= coin;
		}
		
		System.out.print(cnt);
	}
}
