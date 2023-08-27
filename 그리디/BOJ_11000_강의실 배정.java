import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a, Integer[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				return a[0] - b[0];
			}
		});

		int answer = 1;
		pq.offer(arr[0][1]);

		for (int i = 1; i < N; i++) {
			if (arr[i][0] >= pq.peek()) {
				pq.poll();
			} else {
				answer++;
			}
			pq.offer(arr[i][1]);
		}

		System.out.println(answer);
		br.close();
	}
}
