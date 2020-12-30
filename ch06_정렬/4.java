public class Main {
	
	public static int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
	
	public static void quickSort(int begin, int end) {
		if (begin >= end) {
			return;
		}
		
		int pivot = array[begin];
		int left = begin + 1;
		int right = end;
		
		while (left <= right) {
			while (left <= right && array[left] <= pivot) {
				++left;
			}
			
			while (right > begin && array[right] >= pivot) {
				--right;
			}
			
			if (left > right) {
				int temp = array[right];
				array[right] = array[begin];
				array[begin] = temp;
			} else {
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
			}
		}
		
		quickSort(begin, right - 1);
		quickSort(right + 1, end);
	}

	public static void main(String[] args) {
		quickSort(0, array.length - 1);
		
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

}
