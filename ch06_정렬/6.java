public class Main {

	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		int max = array[0];
		
		for (int num : array) {
			max = Math.max(max, num);
		}
		
		int[] count = new int[max + 1];
		
		for (int num : array) {
			++count[num];
		}
		
		for (int i = 0; i <= max; ++i) {
			for (int j = 0; j < count[i]; ++j) {
				System.out.print(i + " ");
			}
		}
	}

}
