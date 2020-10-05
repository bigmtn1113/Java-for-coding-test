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
		
		int maxNum = 1;	// 동전 화폐 단위 다 더한 값까지 답을 못 찾으면 그 다음 값이 최소값이므로 +1
		for (int i = 0; i < n; ++i)
			maxNum += coin[i];
		
		int minNum = 0;
		while (minNum <= maxNum) {
			int checkNum = ++minNum;
			
			for (int i = n - 1; i >= 0; --i)	// 화폐 단위가 큰 것부터 빼기
				if (checkNum - coin[i] >= 0)
					checkNum -= coin[i];
			
			if (checkNum > 0) break;	// 만들 수 없는 수를 발견하면 반복문 탈출
		}
		
		bw.write(String.valueOf(minNum));
		bw.flush();
		bw.close();
	}

}
