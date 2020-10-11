public class Main {
	
	public static int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
	
	public static void quickSort(int begin, int end) {
		if (begin >= end) return;
		
		int pivot = array[begin];
		int left = begin + 1;
		int right = end;
		
		while (left <= right) {
			while (left <= right && array[left] <= pivot) ++left;
			while (right > begin && array[right] >= pivot) --right;
			
			if (left > right) {
				int temp = array[begin];
				array[begin] = array[right];
				array[right] = temp;
			} else {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		
		quickSort(begin, right - 1);
		quickSort(right + 1, end);
	}

	public static void main(String[] args) {
		quickSort(0, array.length - 1);
		
		for (int i : array)
			System.out.print(i + " ");
	}

}
