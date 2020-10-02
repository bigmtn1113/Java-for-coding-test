import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		
		br.close();
		
		Arrays.sort(arr);

		int firstMaxNum = arr[n - 1];
		int secondMaxNum = arr[n - 2];
		int sum = 0;
		
		while (true) {
			for (int i = 0; i < k; ++i) {
				if (m == 0) break;
				
				sum += firstMaxNum;
				--m;
			}
			
			if (m == 0) break;
			
			sum += secondMaxNum;
			--m;
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
	
}
