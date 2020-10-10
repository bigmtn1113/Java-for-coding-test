import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
}

public class Main {
	
	public static int[][] graph = new int[200][200];
	public static int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static int n, m;
	
	public static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(x, y));
		
		while (!queue.isEmpty()) {
			int currX = queue.peek().getX();
			int currY = queue.poll().getY();
			
			for (int i = 0; i < 4; ++i) {
				int nextX = currX + directions[i][0];
				int nextY = currY + directions[i][1];
				
				if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1) continue;
				if (graph[nextX][nextY] == 0) continue;
				
				if (graph[nextX][nextY] == 1) {
					queue.offer(new Position(nextX, nextY));
					graph[nextX][nextY] = graph[currX][currY] + 1;
					
					if (nextX == n - 1 && nextY == m - 1) return;
				}
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
			
			for (int j = 0; j < m; ++j)
				graph[i][j] = row.charAt(j) - '0';
		}
		sc.close();
		
		bfs(0, 0);
		System.out.print(graph[n - 1][m - 1]);
	}

}
