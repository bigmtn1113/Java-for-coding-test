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
		
		int[] ballWeight = new int[n];
		int[] ballCnt = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			ballWeight[i] = Integer.parseInt(st.nextToken());
			++ballCnt[ballWeight[i]];
		}
		br.close();
		
		int cnt = 0;
		for (int i = 1; i <= m; ++i) {
			n -= ballCnt[i];	// 공 개수 - 무게가 i인 볼링공 개수 = A의 경우의 수
			cnt += ballCnt[i] * n;	// 무게가 i인 볼링공 개수 * 공 개수 = B의 경우의 수
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

}
