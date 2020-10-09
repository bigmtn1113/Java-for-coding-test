import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String position = sc.next();
		sc.close();
		
		int x = position.charAt(0) - 'a' + 1;
		int y = position.charAt(1) - '0';
		int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}};
		
		int cnt = 0;
		for (int[] next : directions) {
			int nextX = 1;
			int nextY = 1;
			
			nextX = x + next[0];
			nextY = y + next[1];
			
			if (nextX >= 1 && nextY >= 1 && nextX <= 8 && nextY <= 8)
				++cnt;
		}
		
		System.out.print(cnt);
	}

}
