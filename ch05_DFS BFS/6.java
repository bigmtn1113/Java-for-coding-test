public class Main {
	
	public static void main(String[] args) {
		int INF = 999999999;
		int[][] graph = {{0, 7, 5}, {7, 0, INF}, {5, INF, 0}};
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

}
