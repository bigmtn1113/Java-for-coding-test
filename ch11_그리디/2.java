import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		int sLength = s.length();
		long sum = s.charAt(0) - '0';
		
		for (int i = 1; i < sLength; ++i) {
			int charToInt = s.charAt(i) - '0';
			
			sum = Math.max(sum + charToInt, sum * charToInt);
		}
		
		System.out.print(sum);
	}

}
