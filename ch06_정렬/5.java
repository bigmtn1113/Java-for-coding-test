public class Main {

	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		
		int max = array[0];
		for (int i : array)
			max = Math.max(max, i);
		
		int[] cnt = new int[max + 1];
		for (int i : array)
			++cnt[i];
		
		for (int i = 0; i <= max; ++i)
			for (int j = 0; j < cnt[i]; ++j)
				System.out.print(i + " ");
	}

}
