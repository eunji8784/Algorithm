import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			map = new int[N / 2][2];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i][0] = x;
				map[i][1] = y;
			}
			
			contact(start);
			
			System.out.printf("#%d %d\n", tc, max);
			
		}

	}

	private static void contact(int start) {
		
		max = 0;
		int idx = 1;
		boolean[] visited = new boolean[101];
		ArrayList<int[]> lst = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {start, idx});
		visited[start] = true;
		idx++;
		
		while (!queue.isEmpty()) {
			
			for (int i = 0; i < map.length; i++) {
				if (map[i][0] == queue.peek()[0] && visited[map[i][1]] == false) {
					queue.offer(new int[] {map[i][1], idx});
					visited[map[i][1]] = true;
				}
			}
			
			int[] tmp = queue.poll();
			lst.add(tmp);
			
			if (!queue.isEmpty() && tmp[1] < queue.peek()[1]) {
				idx++;
			}
			
		}
		
		for (int i = lst.size() - 1; i >= 0; i--) {
			if (lst.get(i)[1] == idx - 1) {
				if (lst.get(i)[0] > max) {
					max = lst.get(i)[0];
				}
			} else {
				break;
			}
		}
		
	}

}
