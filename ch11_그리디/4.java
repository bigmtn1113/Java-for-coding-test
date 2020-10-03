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
		
		int n = Integer.parseInt(br.readLine());
		int[] coin = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			coin[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		Arrays.sort(coin);
		
		int num = 0;
		for (int i = 0; i < n; ++i)
			num += coin[i];
		
		int minNum = ++num;
		while (true) {
			if (num <= 0) break;
			
			int temp = num;
			for (int i = n - 1; i >= 0; --i) {
				if (temp - coin[i] < 0) continue;
				
				temp -= coin[i];
			}
			
			if (temp > 0)	// 만들 수 없는 수
				minNum = Math.min(minNum, num);	// 만들 수 없는 수 중 최소값
			
			--num;
		}
		
		bw.write(String.valueOf(minNum));
		bw.flush();
		bw.close();
	}

}
