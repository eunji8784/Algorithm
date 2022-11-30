import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, ans;
	static int[][] adj;
	static int[] voters;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			adj = new int[N + 1][N + 1];
			voters = new int[N + 1];
			StringTokenizer st;
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < N + 1; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N + 1; i++) {
				voters[i] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(1,  new boolean[N + 1]);
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		
	}
	
	private static void powerSet(int idx, boolean[] sel) {
		
		if (idx == N + 1) {
			
			ArrayList<Integer> areaA = new ArrayList<>();
			ArrayList<Integer> areaB = new ArrayList<>();
			
			for (int i = 1; i < sel.length; i++) {
				if (sel[i]) {
					areaA.add(i);
				} else {
					areaB.add(i);
				}
			}
			
			if (areaA.size() == 0 || areaB.size() == 0) {
				return;
			}
			
//			System.out.println("areaA = " + areaA);
//			System.out.println("areaB = " + areaB);
//			System.out.println("----------------------");
			
			boolean[] v = new boolean[N + 1];
			dfs(areaA.get(0), areaA, v);
			dfs(areaB.get(0), areaB, v);
			
			boolean flag = true;
			for (int i = 1; i < v.length; i++) {
				if (!v[i]) {
					flag = false;
				}
			}
			
			if (flag) {
				int sumA = 0, sumB = 0;
				for (int i = 0; i < areaA.size(); i++) {
					sumA += voters[areaA.get(i)];
				}
				for (int i = 0; i < areaB.size(); i++) {
					sumB += voters[areaB.get(i)];
				}
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			
			return;
		}
		
		sel[idx] = true;
		powerSet(idx + 1, sel);
		sel[idx] = false;
		powerSet(idx + 1, sel);
		
	}

	private static void dfs(Integer idx, ArrayList<Integer> area, boolean[] v) {
		
		v[idx] = true;
		for (int i = 0; i < area.size(); i++) {
			if (adj[idx][area.get(i)] == 1 && !v[area.get(i)]) {
				dfs(area.get(i), area, v);
			}
		}
		
	}

}
