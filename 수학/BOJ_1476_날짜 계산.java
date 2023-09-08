import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 7980; i++) {
			if ((i % 15 == 0 ? 15 : i % 15) == E && (i % 28 == 0 ? 28 : i % 28) == S && (i % 19 == 0 ? 19 : i % 19) == M) {
				System.out.println(i);
				break;
			}
		}
		
		br.close();
	}

}
