public class Main {

	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for (int i = 0; i < array.length; ++i) {
			int minIndex = i;
			
			for (int j = i + 1; j < array.length; ++j) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

}
