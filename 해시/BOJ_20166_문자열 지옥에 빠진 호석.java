import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	// [상] 부터 반시계 방향으로
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int N, M, K, maxLength;
	static char[][] board;
	static String[] strToFind;
	static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		map = new HashMap<>(K);
		strToFind = new String[K];
		maxLength = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}

		for (int i = 0; i < K; i++) {
			strToFind[i] = br.readLine();
			maxLength = Math.max(maxLength, strToFind[i].length());
			map.put(strToFind[i], 0);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(Character.toString(board[i][j]), i, j);
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for (String str : strToFind) {
			sb.append(map.get(str)).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(String str, int x, int y) {

		if (str.length() > maxLength) {
			return;
		}

		// 찾으려는 문자열을 발견하면
		if (map.containsKey(str)) {
			map.put(str, map.get(str) + 1);
		}

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx == -1) {
				nx = N - 1;
			}

			if (nx == N) {
				nx = 0;
			}

			if (ny == -1) {
				ny = M - 1;
			}

			if (ny == M) {
				ny = 0;
			}

			dfs(str + board[nx][ny], nx, ny);
		}

	}

}
