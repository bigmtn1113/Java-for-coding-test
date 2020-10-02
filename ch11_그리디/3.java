import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		br.close();
		
		int oneCnt = 0;
		int zeroCnt = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			int j = 0;
			
			if (s.charAt(i) == '0') {	// 뒤집어야 할 0의 개수 파악
				for (j = i + 1; j < s.length(); ++j)
					if (s.charAt(j) == '1') break;
				
				++zeroCnt;
			} else if (s.charAt(i) == '1') {	// 뒤집어야 할 1의 개수 파악
				for (j = i + 1; j < s.length(); ++j)
					if (s.charAt(j) == '0') break;
				
				++oneCnt;
			}
			
			i = j - 1;
		}
		
		bw.write(String.valueOf(Math.min(zeroCnt, oneCnt)));
		bw.flush();
		bw.close();
	}

}
