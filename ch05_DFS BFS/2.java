import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(5);
		queue.offer(2);
		queue.offer(3);
		queue.offer(7);
		queue.poll();
		queue.offer(1);
		queue.offer(4);
		queue.poll();
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
