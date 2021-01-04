import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		int sLength = s.length();
		int sum = 0;
		ArrayList<Character> list = new ArrayList<>();
		
		for (int i = 0; i < sLength; ++i) {
			char c = s.charAt(i);
			
			if (Character.isAlphabetic(c)) {
				list.add(c);
			} else {
				sum += c - '0';
			}
		}
		
		Collections.sort(list);
		
		for (char c : list) {
			System.out.print(c);
		}
		
		if (sum > 0) {
			System.out.print(sum);
		}
	}

}
