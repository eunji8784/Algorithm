import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new LinkedHashMap<>();
			
			for (int i = 2; i * i <= N; i++) {
				while (N % i == 0) {
					map.put(i, map.getOrDefault(i, 0) + 1);
					N /= i;
				}
			}
			
			if (N > 1) map.put(N, map.getOrDefault(N, 0) + 1);
			
			StringBuilder sb = new StringBuilder();
			
			for (int key : map.keySet()) {
				sb.append(key).append(" ").append(map.get(key)).append("\n");
			}
			
			System.out.print(sb.toString());
		}
		
		
		br.close();
	}

}
