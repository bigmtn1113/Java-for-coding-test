import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] plans = sc.nextLine().split(" ");
		sc.close();
		
		int x = 1;
		int y = 1;
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		
		for (String plan : plans) {
			int nextX = x;
			int nextY = y;
			char moveType = plan.charAt(0);
			
			for (int i = 0; i < 4; ++i) {
				if (moveType != moveTypes[i]) {
					continue;
				}
				
				nextX += directions[i][0];
				nextY += directions[i][1];
				break;
			}
			
			if (nextX < 1 || nextY < 1 || nextX > n || nextY > n) {
				continue;
			}
			
			x = nextX;
			y = nextY;
		}
		
		System.out.print(x + " " + y);
	}

}
