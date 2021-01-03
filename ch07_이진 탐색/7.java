import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; ++i) {
			set.add(sc.nextInt());
		}
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			System.out.print((set.contains(sc.nextInt()) == true) ? "yes " : "no ");
		}
		sc.close();
	}

}
