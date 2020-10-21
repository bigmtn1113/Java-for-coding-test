import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		sc.close();
		
		int left = 0;
		int right = 0;
		int nLength = n.length();
		for (int i = 0; i < nLength; ++i) {
			if (i < nLength / 2) left += n.charAt(i) - '0';
			else right += n.charAt(i) -'0';
		}
		
		System.out.print(left == right ? "LUCKY" : "READY");
	}

}
