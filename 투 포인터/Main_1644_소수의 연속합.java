import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        if (N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		ArrayList<Integer> primeList = new ArrayList<>();
		
		for (int i = 2; i * i <= N; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) primeList.add(i);
		}
		
		int answer = 0, start = 0, end = 0, sum = primeList.get(0);
		
		while (start <= end) {
			if (sum <= N) {
				if (sum == N) answer++;
				if (end + 1 >= primeList.size()) break;
				sum += primeList.get(++end);
			} else {
				sum -= primeList.get(start++);
			}
		}

		System.out.println(answer);
		br.close();
	}

}
