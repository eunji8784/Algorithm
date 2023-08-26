import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int INF = (int) Math.round(Math.sqrt(B));
		boolean[] isNotPrime = new boolean[INF + 1];
		int answer = 0;
		
		// 에라토스테네스의 체
		for (int i = 2; i <= Math.sqrt(INF); i++) {
			if (isNotPrime[i]) continue;
			for (int j = i * i; j <= INF; j += i) {
				isNotPrime[j] = true;
			}
		}

		// 제곱근 판별
		for (int i = 2; i <= INF; i++) {
			if (isNotPrime[i]) continue;
			long val = i;
			while (true) {
				if (val > B / i) break; // 오버플로우 검사 
				val *= i;
				if (val >= A) answer++;
			}
		}

		System.out.println(answer);
		br.close();
	}
}
