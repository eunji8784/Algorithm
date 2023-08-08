import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				sb.append(i + "\n");
				N /= i;
			}
		}
		
		if (N > 1) {
			sb.append(N + "\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}

}
