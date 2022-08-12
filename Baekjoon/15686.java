import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static ArrayList<int[]> homes = new ArrayList<int[]>();
	static ArrayList<int[]> chickens = new ArrayList<int[]>();
	static int[][] selected;
	static int distance;
	static int minDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		selected = new int[M][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					homes.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					chickens.add(new int[] { i, j });
				}
			}
		}
		
		chickenCom(0,0);
		
		System.out.print(minDistance);

	}

	private static void chickenCom(int idx, int count) {

		if (count == M) {
			distance = getChickenDistance(selected);
			
			if (distance < minDistance) {
				minDistance = distance;
			}
			
			return;
		}

		for (int i = idx; i < chickens.size(); i++) {
			selected[count] = chickens.get(i);
			chickenCom(i + 1, count + 1);
		}

	}

	private static int getChickenDistance(int[][] selected) {

		distance = 0;
		int res;

		for (int[] h : homes) {
			int min = Integer.MAX_VALUE;
			for (int[] s : selected) {
				res = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
				if (res < min) {
					min = res;
				}
			}
			distance += min;
		}
		
		return distance;

	}

}
