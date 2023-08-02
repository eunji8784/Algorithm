import java.io.*;
import java.util.*;

public class Main {

	static int[] locArr;
	static Deque<Integer> dq = new LinkedList<>();
	static int Ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		locArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			locArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		Solution();
		System.out.println(Ans);
		br.close();
	}

	private static void Solution() {

		for (int loc : locArr) {

			while (true) {

				if (loc == dq.peekFirst()) {
					dq.pollFirst();
					break;
				}

				Ans++;

				int idx = new ArrayList<>(dq).indexOf(loc);

				if (idx > dq.size() / 2) {
					dq.offerFirst(dq.pollLast());
				} else {
					dq.offerLast(dq.pollFirst());
				}

			}

		}

	}

}
