import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
	private int time;
	private int index;

	public Food(int time, int index) {
		this.time = time;
		this.index = index;
	}

	public int getTime() {
		return time;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Food o) {
		return time - o.time;
	}
}

public class Solution {

	public int solution(int[] food_times, long k) {
		long foodTimeSum = 0;

		for (int food_time : food_times) {
			foodTimeSum += food_time;
		}

		if (foodTimeSum <= k) {
			return -1;
		}

		PriorityQueue<Food> queue = new PriorityQueue<>();

		for (int i = 0; i < food_times.length; ++i) {
			queue.offer(new Food(food_times[i], i + 1));
		}

		long prevFoodTime = 0;

		while (true) {
			int foodTime = queue.peek().getTime();
			long oneCycle = (foodTime - prevFoodTime) * queue.size();

			if (k < oneCycle) {
				break;
			}

			k -= oneCycle;
			prevFoodTime = foodTime;

			queue.poll();
		}

		ArrayList<Food> result = new ArrayList<>();

		while (!queue.isEmpty()) {
			result.add(queue.poll());
		}

		Collections.sort(result, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return o1.getIndex() - o2.getIndex();
			}
		});

		return result.get((int) (k % result.size())).getIndex();
	}

}
