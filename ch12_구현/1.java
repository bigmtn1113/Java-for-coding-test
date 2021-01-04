import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		sc.close();
		
		int nLength = n.length();
		int nLengthDividedBy2 = nLength / 2;
		int leftSum = 0;
		int rightSum = 0;
		
		for (int i = 0; i < nLength; ++i) {
			if (i < nLengthDividedBy2) {
				leftSum += n.charAt(i) - '0';
			} else {
				rightSum += n.charAt(i) - '0';
			}
		}
		
		System.out.print((leftSum == rightSum) ? "LUCKY" : "READY");
	}

}
