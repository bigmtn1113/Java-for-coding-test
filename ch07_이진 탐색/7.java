import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> s = new HashSet<>();
		
		for (int i = 0; i < n; ++i)
			s.add(sc.nextInt());
		
		int m = sc.nextInt();
		for (int i = 0; i < m; ++i)
			System.out.print(s.contains(sc.nextInt()) == false ? "no " : "yes "); 
		sc.close();
	}

}
