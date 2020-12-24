import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 1260;
		int cnt = 0;
        	int[] coin = {500, 100, 50, 10};
		
        	for (int i = 0; i < 4; i++) {
            		cnt += n / coin[i];
            		n %= coin[i];
        	}
        
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

}
