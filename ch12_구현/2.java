import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		sc.close();
		
		ArrayList<Character> arr = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < n.length(); ++i) {
			char c = n.charAt(i);
			
			if (Character.isAlphabetic(c)) arr.add(c);
			else sum += c - '0';
		}
		
		Collections.sort(arr);
		for(int i = 0; i < arr.size(); ++i)
			System.out.print(arr.get(i));
		
		if (sum != 0) System.out.print(sum);
	}

}
