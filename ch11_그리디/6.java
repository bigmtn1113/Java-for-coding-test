public class Solution {

	public int solution(int[] food_times, long k) {
		long foodTimesSum = 0;
		for (int i = 0; i < food_times.length; ++i)
			foodTimesSum += food_times[i];
		
		if (foodTimesSum <= k) return -1;
		
		int answer = 0;
		while (k > 0) {
			for (int i = 0; i < food_times.length; ++i) {
				if (food_times[i] > 0) {
					--food_times[i];
					--k;
					
					if (k == 0) {
						answer = i;
						break;
					}
				}
			}
		}
		
		boolean check = false;
		for (int i = (answer + 1) % food_times.length; i < food_times.length; ++i) {
			if (food_times[i] > 0) {
				answer = i;
				check = true;
				break;
			}
		}
		
		if (!check ) {
			for (int i = 0; i < answer; ++i) {
				if (food_times[i] > 0) {
					answer = i;
					break;
				}
			}
		}
		
		return answer + 1;
	}

}
