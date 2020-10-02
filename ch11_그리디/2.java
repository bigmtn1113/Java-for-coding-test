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
		
		int sum = s.charAt(0) - '0';
		for (int i = 1; i < s.length(); ++i) {
			int num = s.charAt(i) - '0';
			
			sum = Math.max(sum + num, sum * num);
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

}
