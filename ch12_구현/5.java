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

class RotationInfo {
	private int x;
	private char c;
	
	public RotationInfo(int x, char c) {
		this.x = x;
		this.c = c;
	}
	
	public int getX() {
		return x;
	}
	
	public char getC() {
		return c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		boolean[][] board = new boolean[n + 1][n + 1];
		
		for (int i = 0; i < k; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			board[x][y] = true;
		}
		
		int l = sc.nextInt();
		
		RotationInfo[] info = new RotationInfo[l];	// 방향 변환 정보를 저장하기 위한 배열
		
		int infoIndex = 0;
		
		for (int i = 0; i < l; ++i) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			
			info[i] = new RotationInfo(x, c);
		}
		sc.close();
		
		int[] snakeHead = {1, 1};
		int[] snakeTail = {1, 1};
		
		boolean[][] snakebody = new boolean[n + 1][n + 1];	// 뱀이 현재 차지하고 있는 좌표는 true
		
		snakebody[1][1] = true;	// 처음 뱀이 위치하는 자리 true
		
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	// D = index + 1, L = index - 1
		
		int directionsIndex = 0;
		int time = 0;
		
		Queue<Coordinate> headCoordinate = new LinkedList<>();	// 머리가 지나간 좌표를 저장하기 위한 큐
		
		while (true) {
			++time;
			
			int nextHeadX = snakeHead[0] + directions[directionsIndex][0];
			int nextHeadY = snakeHead[1] + directions[directionsIndex][1];
			
			if (nextHeadX < 1 || nextHeadY < 1 || nextHeadX > n || nextHeadY > n) { // 머리가 벽에 부딪히면 끝
				break;
			}
			
			if (snakebody[nextHeadX][nextHeadY]) { // 머리가 몸에 부딪히면 끝
				break;
			}
			
			snakeHead[0] = nextHeadX;	// 머리 이동
			snakeHead[1] = nextHeadY;
			
			snakebody[snakeHead[0]][snakeHead[1]] = true;	// 머리가 위치한 자리 true
			
			headCoordinate.offer(new Coordinate(snakeHead[0], snakeHead[1]));
			
			if (!board[snakeHead[0]][snakeHead[1]]) {	// 사과가 없을 경우
				snakebody[snakeTail[0]][snakeTail[1]] = false;	// 꼬리가 있던 자리 false
								
				snakeTail[0] = headCoordinate.peek().getX();	// 꼬리가 머리가 지나왔던 좌표로 이동
				snakeTail[1] = headCoordinate.poll().getY();
				
				snakebody[snakeTail[0]][snakeTail[1]] = true;	// 꼬리가 위치한 자리 true
			} else {	// 사과가 있을 경우
				board[snakeHead[0]][snakeHead[1]] = false;	// 사과 있던 자리 false
			}
			
			if (infoIndex < l) {	// 방향 변환 정보가 남아 있으면
				if (time == info[infoIndex].getX()) {	// 방향 변환 시간이 되었을 경우
					char nextD = info[infoIndex].getC();
					
					directionsIndex = (nextD == 'L') ? directionsIndex - 1 : directionsIndex + 1; // L이면 다음 방향을 왼쪽으로 90도, D면 다음 방향을 오른쪽으로 90도 설정
					
					if (directionsIndex < 0) { // index가 넘어갈 경우
						directionsIndex = 3;
					} else if (directionsIndex > 3) {
						directionsIndex = 0;
					}
					
					++infoIndex;
				}
			}
		}
		
		System.out.print(time);
	}

}
