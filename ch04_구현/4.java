import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		byte[][] map = new byte[n][m];
		boolean[][] isVisit = new boolean[n][m];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		isVisit[a][b] = true;
		
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < m; ++j)
				map[i][j] = sc.nextByte();
		sc.close();
		
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		int cnt = 1;
		int check = 0;
		while (true) {
			int nextA = 0, nextB = 0;
			
			d = (d == 0) ? 3 : d - 1;
			++check;
			
			nextA = a + directions[d][0];
			nextB = b + directions[d][1];
			
			if (map[nextA][nextB] == 1 || isVisit[nextA][nextB]) {
				if (check != 4) continue;
				
				a += directions[(d + 2) % 4][0];
				b += directions[(d + 2) % 4][1];
				
				if (map[a][b] == 1) break;
				check = 0;
			} else {
				a = nextA;
				b = nextB;
				isVisit[a][b] = true;
				
				++cnt;
				check = 0;
			}
		}
		System.out.println(cnt);
	}

}
