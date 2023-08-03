import java.io.*;
import java.util.*;

public class Main {
	
	static long P, Q;
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		map.put(0L, 1L);
		
		System.out.print(Solution(N));
		br.close();

	}

	private static long Solution(long n) {
		
		if (map.containsKey(n)) {
			return map.get(n);
		}
		
		long val = Solution(n / P) + Solution(n / Q);
		map.put(n, val);
		return val;
		
	}

}
