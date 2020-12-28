import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		byte[][] map = new byte[n][m];
		boolean[][] visited = new boolean[n][m];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		
		visited[a][b] = true;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				map[i][j] = sc.nextByte();
			}
		}
		sc.close();
		
		int cnt = 1;
		int check = 0;
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while (true) {
			int nextA = a;
			int nextB = b;
			
			d = (d == 0) ? 3 : d - 1;
			++check;
			
			nextA += directions[d][0];
			nextB += directions[d][1];
			
			if (map[nextA][nextB] == 1 || visited[nextA][nextB]) {
				if (check != 4) {
					continue;
				}
				
				a += directions[(d + 2) % 4][0];
				b += directions[(d + 2) % 4][1];
				
				if (map[a][b] == 1) {
					break;
				}
				
				check = 0;
			} else {
				a = nextA;
				b = nextB;
				visited[a][b] = true;
				
				++cnt;
				check = 0;
			}
		}
		
		System.out.println(cnt);
	}

}
