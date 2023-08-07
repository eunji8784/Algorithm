import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (pq.size() == N) {
					if (num > pq.peek()) {
						pq.poll();
						pq.offer(num);
					}
				} else {
					pq.offer(num);
				}
			}
		}
		
		System.out.println(pq.poll());
		br.close();
	}

}
