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
		int[] fear = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			fear[i] = Integer.parseInt(st.nextToken());
		br.close();
		
		Arrays.sort(fear);	// 오름차순 정렬
		
		int cnt = 0;	// 여행을 떠날 수 있는 그룹 수
		for (int i = n - 1; i >= 0; --i) {
			if (n < fear[i]) break;	// 현재 남은 인원의 수보다 공포도가 큰 인원이 있으면
			
			n -= fear[i];	// 공포도만큼 사람들을 그룹에 편성. 3이면 3명 편성
			i -= fear[i] - 1;	// 공포도가 큰 사람들부터 그룹에 편성
			++cnt;
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

}
