import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] plans = sc.nextLine().split(" ");
		sc.close();
		
		int x = 1;
		int y = 1;
		char[] movements = { 'U', 'L', 'R', 'D' };
		int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
		
		for (String plan : plans) {
			char nextMovement = plan.charAt(0);
			int nextX = 1;
			int nextY = 1;
			
			for (int j = 0; j < 4; ++j) {
				if (nextMovement != movements[j]) continue;
				
				nextX = x + directions[j][0];
				nextY = y + directions[j][1];
				break;
			}
			
			if (nextX < 1 || nextY < 1 || nextX > n || nextY > n) continue;
			
			x = nextX;
			y = nextY;
		}
		
		System.out.print(x + " " + y);
	}

}
