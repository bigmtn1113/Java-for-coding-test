public class Main {

	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for (int i = 1; i < array.length; ++i) {
			for (int j = i; j > 0; --j) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				} else break;
			}
		}
		
		for (int i : array)
			System.out.print(i + " ");
	}

}
