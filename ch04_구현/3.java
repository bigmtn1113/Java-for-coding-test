import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String location = sc.next();
		sc.close();
		
		int x = location.charAt(0) - 'a' + 1;
		int y = location.charAt(1) - '0';
		int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2}, 
					{2, -1}, {2, 1}, {-1, 2}, {1, 2}};
		
		int cnt = 0;
		
		for (int[] direction : directions) {
			int nextX = x + direction[0];
			int nextY = y + direction[1];
			
			if (nextX < 1 || nextY < 1 || nextX > 8 || nextY > 8) {
				continue;
			}
			
			++cnt;
		}
		
		System.out.print(cnt);
	}

}
