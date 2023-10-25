import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int N, M, P;
	private static int[] S, players;
	private static int[][] map;
	private static Queue<Location>[] ques;
	
	private static class Location {
		int x, y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		S = new int[P + 1];
		players = new int[P + 1];
		map = new int[N][M];
		ques = new LinkedList[P + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= P; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			ques[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (tmp[j] == '.') {
					map[i][j] = 0;
				} else if (tmp[j] == '#') {
					map[i][j] = -1;
				} else {
					map[i][j] = tmp[j] - '0';
				}
				if (map[i][j] > 0) {
					ques[map[i][j]].offer(new Location(i, j));
					players[map[i][j]]++;
				} 
			}
		}
		
		while(true) {
			if (!solve()) break;
		}
		
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= P; i++) {
			answer.append(players[i] + " ");
		}
		
		System.out.println(answer.toString());
		br.close();
	}
	
	private static boolean solve() {
		boolean expanded = false;
		for (int p = 1; p <= P; p++) {
			Queue<Location> que = ques[p];
			for (int move = 0; move < S[p]; move++) {
				int size = que.size();
				if (size == 0) break;
				
				for (int s = 0; s < size; s++) {
					Location cur = que.poll();
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + DX[dir];
						int ny = cur.y + DY[dir];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						
						if (map[nx][ny] == 0) {
							map[nx][ny] = p;
							players[p]++;
							que.offer(new Location(nx, ny));
							expanded = true;
						}
					}
				}
			}
		}
		return expanded;
	}
}
