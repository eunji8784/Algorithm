import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int N;
	static int[] population;
	static ArrayList<Integer>[] adjLst;
	static int[] selected;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		adjLst = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjLst[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				adjLst[i].add(v);
			}
		}

		for (int r = 1; r <= N / 2; r++) {
			selected = new int[r];
			combination(0, 0, r);
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void combination(int index, int count, int r) {

		if (count == r) {
			divisionArea(selected);
			return;
		}

		for (int i = index; i < N; i++) {
			selected[count] = i + 1;
			combination(i + 1, count + 1, r);
		}

	}

	private static void divisionArea(int[] area1) {

		int[] area2 = new int[N - area1.length];
		boolean status;
		int idx = 0;

		for (int i = 1; i <= N; i++) {
			status = false;
			for (int j = 0; j < area1.length; j++) {
				if (area1[j] == i) {
					status = true;
					break;
				}
			}
			if (!status) {
				area2[idx] = i;
				idx++;
			}
		}
		
		visited = new boolean[N + 1];
		Arrays.fill(visited, true);
		for (int i = 0; i < area1.length; i++) {
			visited[area1[i]] = false;
		}

		if (bfs(area1[0], area1)) {
			visited = new boolean[N + 1];
			Arrays.fill(visited, true);
			for (int i = 0; i < area2.length; i++) {
				visited[area2[i]] = false;
			}
			if (bfs(area2[0], area2)) {
				int differ = calPopulationDiffer(area1, area2);
				if (differ < min) {
					min = differ;
				}
			}
		} 
	}

	private static int calPopulationDiffer(int[] area1, int[] area2) {

		int differ = 0;
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < area1.length; i++) {
			sum1 += population[area1[i]];
		}

		for (int i = 0; i < area2.length; i++) {
			sum2 += population[area2[i]];
		}

		differ = Math.abs(sum1 - sum2);

		return differ;

	}

	private static boolean bfs(int start, int[] area) {

		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		int count = 0;

		while (!queue.isEmpty()) {
			int v = queue.poll();
			count++;
			for (int e : adjLst[v]) {
				if (!visited[e]) {
					visited[e] = true;
					queue.offer(e);
				}
			}
		}

		if (count == area.length) {
			return true;
		} else {
			return false;
		}

	}

}
