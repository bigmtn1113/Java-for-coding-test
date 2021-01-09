import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		int zeroCount = 0;
		int oneCount = 0;
		int sLength = s.length();
		
		for (int i = 0; i < sLength; ) {
			char c = s.charAt(i);
			
			if (c == '0') {
				++zeroCount;
			} else if (c == '1') {
				++oneCount;
			}
			
			++i;
			
			while ((i < sLength) && (c == s.charAt(i))) {
				++i;
			}
		}
		
		System.out.print(Math.min(zeroCount, oneCount));
	}

}
