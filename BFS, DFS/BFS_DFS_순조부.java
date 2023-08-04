import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_순조부 {

	static int n = 5;
	static int r = 3;
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int[] selected;
	static boolean[] visited;
	
	static ArrayList<Integer>[] adjLst;

	public static void main(String[] args) throws IOException {

		System.out.println("=========순열=========");
		selected = new int[r];
		visited = new boolean[n];
		permutation(0);
		System.out.println("=========조합=========");
		selected = new int[r];
		combination(0, 0);
		System.out.println("=========부분집합=========");
		selected = new int[n];
		subset(0, 0);
		
		System.out.println("=========DFS와 BFS=========");
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		adjLst = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjLst[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjLst[a].add(b);
			adjLst[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(adjLst[i]);
		}
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);

	}

	private static void bfs(int v) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			int e = queue.poll();
			System.out.print(e + " ");
			for (int i : adjLst[e]) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

	private static void dfs(int v) {
		
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int e : adjLst[v]) {
			if (!visited[e]) {
				dfs(e);
			}
		}
		
	}

	// 부분집합
	private static void subset(int index, int count) {
		
		if (index == n) {
			ArrayList<Integer> lst = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				lst.add(selected[i]);
			}
			System.out.println(lst);
			return;
		}
		
		subset(index + 1, count);
		selected[count] = arr[index]; 
		subset(index + 1, count + 1);
		
	}

	// 조합
	private static void combination(int index, int count) {

		if (count == r) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = index; i < n; i++) {
			selected[count] = arr[i];
			combination(i + 1, count + 1);
		}

	}

	// 중복조합 
	private static void combinationWithRepetition(int index, int count) {

	    if (count == r) {
	        System.out.println(Arrays.toString(selected));
	        return;
	    }
	
	    for (int i = index; i < n; i++) {
	        selected[count] = arr[i];
	        // 현재 원소를 다시 선택할 수 있도록, 다음 조합의 시작 인덱스를 i로 설정
	        combination(i, count + 1);
	    }
	}

	// 순열
	private static void permutation(int depth) {

		if (depth == r) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}

	}

	// 중복순열
	private static void permutationWithRepetition(int depth) {

	    if (depth == r) {
	        System.out.println(Arrays.toString(selected));
	        return;
	    }
	
	    for (int i = 0; i < n; i++) {
	        selected[depth] = arr[i];
	        permutationWithRepetition(depth + 1);
	    }
	}

}
