import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] loc;
	static ArrayList<Integer>[] adjLst;
	static int[][] selected;
	static boolean[] vst;
	static boolean happy;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine());
			adjLst = new ArrayList[n + 2];
			vst = new boolean[n + 2];
			for (int i = 0; i < n + 2; i++) {
				adjLst[i] = new ArrayList<>();
			}
			loc = new int[n + 2][2];
			StringTokenizer st;
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n + 1; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if(getDistance(loc[i], loc[j]) <= 1000) {
						adjLst[i].add(j);
						adjLst[j].add(i);
					}
				}
			}
			happy = false;
			bfs(0);
			
			if (happy) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		vst[start] = true;
		
		while (!que.isEmpty()) {
			int v = que.poll();
			if(v == n + 1) {
				happy = true;
				break;
			}
			for (Integer lst : adjLst[v]) {
				if (!vst[lst]) {
					vst[lst] = true;
					que.add(lst);
				}
			}
		}
	}

	private static int getDistance(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
	}

}
