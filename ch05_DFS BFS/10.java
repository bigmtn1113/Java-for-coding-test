import java.util.Scanner;

public class Main {
	public static int[][] iceFrame = new int[1000][1000];
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int n, m;
	
	public static void dfs(int x, int y) {
		iceFrame[x][y] = 1;
		
		for (int[] direction : directions) {
			int nextX = x + direction[0];
			int nextY = y + direction[1];
			
			if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1) {
				continue;
			}
			
			if (iceFrame[nextX][nextY] != 1) {
				dfs(nextX, nextY);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; ++i) {
			String row = sc.nextLine();
			
			for (int j = 0; j < m; ++j) {
				iceFrame[i][j] = row.charAt(j) - '0';
			}
		}
		sc.close();
		
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (iceFrame[i][j] == 0) {
					dfs(i, j);
					++cnt;
				}
			}
		}
		
		System.out.print(cnt);
	}

}
