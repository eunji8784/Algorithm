import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			System.out.println(N / H + (N % H == 0 ? 0 : 1) + (N % H == 0 ? H : N % H) * 100);
		}
		
		br.close();
	}

}
