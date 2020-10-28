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

class Information {
	private int x;
	private char c;
	
	public Information(int x, char c) {
		this.x = x;
		this.c = c;
	}
	
	public int getX() { return x; }
	public char getC() { return c; }
}

public class Main {
	public static boolean[][] board = new boolean[101][101];
	public static boolean[][] snakebody = new boolean[101][101];	// 뱀이 현재 차지하고 있는 좌표는 true

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for (int i = 0; i < k; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			board[x][y] = true;
		}
		
		int l = sc.nextInt();
		Queue<Information> info = new LinkedList<>();	// 방향 변환 정보를 저장하기 위한 큐
		for (int i = 0; i < l; ++i) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			
			info.offer(new Information(x, c));
		}
		sc.close();
		
		snakebody[1][1] = true;	// 처음 뱀이 위치하는 자리 true
		int[][] snake = {{1, 1}, {1, 1}};	// {{머리 좌표}, {꼬리 좌표}}
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	// D = index + 1, L = index - 1
		Queue<Position> headPosition = new LinkedList<>();	// 머리가 지나간 좌표를 저장하기 위한 큐
		
		int cnt = 0;
		int directionsIndex = 0;
		while (true) {
			int nextHeadX = snake[0][0] + directions[directionsIndex][0];
			int nextHeadY = snake[0][1] + directions[directionsIndex][1];
			++cnt;
			
			if (nextHeadX < 1 || nextHeadY < 1 || nextHeadX > n || nextHeadY > n) break;	// 머리가 벽에 부딪히면 끝
			if (snakebody[nextHeadX][nextHeadY]) break;	// 머리가 몸에 부딪히면 끝
			
			snake[0][0] = nextHeadX;	// 머리 이동
			snake[0][1] = nextHeadY;
			snakebody[snake[0][0]][snake[0][1]] = true;	// 머리가 위치한 자리 true
			headPosition.offer(new Position(snake[0][0], snake[0][1]));	// 머리 좌표를 큐에 삽입
			
			if (!board[nextHeadX][nextHeadY]) {	// 사과가 없을 경우
				snakebody[snake[1][0]][snake[1][1]] = false;	// 꼬리가 있던 자리 false
								
				snake[1][0] = headPosition.peek().getX();	// 꼬리가 머리가 지나왔던 좌표로 이동
				snake[1][1] = headPosition.poll().getY();
				
				snakebody[snake[1][0]][snake[1][1]] = true;	// 꼬리가 위치한 자리 true
			} else {	// 사과가 있을 경우
				board[nextHeadX][nextHeadY] = false;	// 사과 있던 자리 false
			}
			
			if (!info.isEmpty()) {	// 방향 변환 정보가 남아 있으면
				if (cnt == info.peek().getX()) {	// 방향 변환 시간이 되었을 경우
					char nextD = info.peek().getC();
					
					if (nextD == 'L') --directionsIndex;	// L이면 다음 방향을 왼쪽으로 90도 설정
					else if (nextD == 'D') ++directionsIndex;	// D면 다음 방향을 오른쪽으로 90도 설정
					
					if (directionsIndex < 0) directionsIndex = 3;	// index가 넘어갈 경우
					else if (directionsIndex > 3) directionsIndex = 0;
					
					info.poll();	// 방향 변환 정보를 사용했으니 빼는 작업 수행
				}
			}
		}
		
		System.out.print(cnt);
	}

}
