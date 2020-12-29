import java.util.ArrayList;

class Node {
	private int node;
	private int distance;
	
	public Node(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	public void show() {
		System.out.print("(" + node + ", " + distance + ") ");
	}
}

public class Main {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < 3; ++i) {
			graph.add(new ArrayList<Node>());
		}
		
		graph.get(0).add(new Node(1, 7));
		graph.get(0).add(new Node(2, 5));
		graph.get(1).add(new Node(0, 7));
		graph.get(2).add(new Node(0, 5));
		
		for (ArrayList<Node> i : graph) {
			for (Node j : i) {
				j.show();
			}
			
			System.out.println();
		}
	}

}
