import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int min = 10000;
			
			for (int j = 0; j < m; ++j) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num < min)
					min = num;
			}
			
			if (min > max)
				max = min;
		}
		br.close();
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

}
