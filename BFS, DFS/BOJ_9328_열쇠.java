import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, 1, 0, 0 };
	private static final int[] DY = { 0, 0, -1, 1 };
	
	private static int h, w;
	private static char[][] map;
	private static boolean[] keys;
	
	private static class Location {
		int x, y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h + 2][w + 2];
			keys = new boolean[26];
			
			for (int i = 0; i < h + 2; i++) {
				Arrays.fill(map[i], '.');
			}
			
			for (int i = 1; i <= h; i++) {
				String str = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}
			
			String tmp = br.readLine();
			if (!tmp.equals("0")) {
				char[] k = tmp.toCharArray();
				for (char key : k) keys[key - 'a'] = true;
			}
            
			answer.append(solve() + "\n");
		}
		
		System.out.print(answer.toString());
		br.close();
	}
	
	private static int solve() {
		int docs = 0;
		
		Queue<Location> que = new LinkedList<>();
		boolean[][] vst = new boolean[h + 2][w + 2];
		List<Location> doors = new ArrayList<>();
		
		que.offer(new Location(0, 0));
		vst[0][0] = true;
		
		while (!que.isEmpty()) {
			Location cur = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
				if (map[nx][ny] == '*' || vst[nx][ny]) continue;
				
				vst[nx][ny] = true;
				char c = map[nx][ny];
				
				if (c == '.') {
					que.offer(new Location(nx, ny));
				}
				
				if (c == '$') {
					docs++;
					que.offer(new Location(nx, ny));
				}
				
				// 문 
				if ('A' <= c && c <= 'Z') { 
					if (keys[c - 'A']) {
						que.offer(new Location(nx, ny));
					} else {
						doors.add(new Location(nx, ny));
					}
				}
				
				// 열쇠
				if ('a' <= c && c <= 'z') {
					keys[c - 'a'] = true;
					que.offer(new Location(nx, ny));
					for (int d = doors.size() - 1; d >= 0; d--) {
						Location door = doors.get(d);
						if (keys[map[door.x][door.y] - 'A']) {
							que.offer(new Location(door.x, door.y));
							doors.remove(d);
						}
					}
				}
			}
      
		}	
		return docs;
	}
}
