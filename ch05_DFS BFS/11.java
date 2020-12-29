import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

public class Main {
	public static int[][] maze = new int[200][200];
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int n;
	public static int m;
	
	public static void bfs(int x, int y) {
		Queue<Coordinate> queue = new LinkedList<>();
		
		queue.offer(new Coordinate(x, y));
		
		while (!queue.isEmpty()) {
			int currX = queue.peek().getX();
			int currY = queue.poll().getY();
			
			for (int[] direction : directions) {
				int nextX = currX + direction[0];
				int nextY = currY + direction[1];
				
				if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1) {
					continue;
				}
				
				if (maze[nextX][nextY] == 1) {
					queue.offer(new Coordinate(nextX, nextY));
					maze[nextX][nextY] = maze[currX][currY] + 1;
					
					if (nextX == n - 1 && nextY == m - 1) {
						return;
					}
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
			
			for (int j = 0; j < m; ++j) {
				maze[i][j] = row.charAt(j) - '0';
			}
		}
		sc.close();
		
		bfs(0, 0);
		System.out.print(maze[n - 1][m - 1]);
	}

}
