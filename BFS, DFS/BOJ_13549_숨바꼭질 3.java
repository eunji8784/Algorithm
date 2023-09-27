import java.io.*;
import java.util.*;

public class Main {

	private static class Location {
		int loc, time;

		public Location(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N, K));
		br.close();
	}

	private static int bfs(int N, int K) {
		PriorityQueue<Location> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
		boolean[] vst = new boolean[100001];
		pq.offer(new Location(N, 0));

		while (!pq.isEmpty()) {
			Location cur = pq.poll();
			int loc = cur.loc;
			int time = cur.time;
			
			if (loc == K || loc * 2 == K) {
				return time;
			}
			
			vst[loc] = true;
			
			if (loc * 2 <= 100000 && !vst[loc * 2]) {
				pq.offer(new Location(loc * 2, time));
			}
			
			if (loc + 1 <= 100000 && !vst[loc + 1]) {
				pq.offer(new Location(loc + 1, time + 1));
			}
			
			if (loc - 1 >= 0 && !vst[loc - 1]) {
				pq.offer(new Location(loc - 1, time + 1));
			}
		}
		
		return -1;
	}
}
