import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return Integer.compare(o1, o2);
				}
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			} else {
				pq.offer(num);
			}
		}
		
		System.out.print(sb.toString());
		br.close();

	}

}
