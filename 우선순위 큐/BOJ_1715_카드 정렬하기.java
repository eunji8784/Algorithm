import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int answer = 0;

		while (pq.size() >= 2) {
			
			int sum = pq.poll() + pq.poll();
			answer += sum;
			pq.offer(sum);

		}
		
		System.out.println(answer);
		br.close();

	}

}
