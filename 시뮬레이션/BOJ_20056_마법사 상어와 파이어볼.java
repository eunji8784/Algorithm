import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[] DY = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static int n, m, k;
	private static ArrayList<FireBall>[][] map, copy;

	private static class FireBall {
		int mass, speed, direction;

		public FireBall(int mass, int speed, int direction) {
			this.mass = mass;
			this.speed = speed;
			this.direction = direction;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new ArrayList[n][n];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = new ArrayList<>();
			map[r - 1][c - 1].add(new FireBall(m, s, d));
		}

		while (k-- > 0) {
			moveFireBall();
		}
		
		int totalMass = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != null && map[i][j].size() > 0) {
					for (int idx = 0; idx < map[i][j].size(); idx++) {
						totalMass += map[i][j].get(idx).mass;
					}
				
				}
			}
		}

		bw.write(String.valueOf(totalMass));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void moveFireBall() {
		copy = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != null && map[i][j].size() > 0) {
					for (int idx = map[i][j].size() - 1; idx >= 0; idx--) {
						FireBall fb = map[i][j].get(idx);
						int nx = (i + DX[fb.direction] * fb.speed) % n;
						int ny = (j + DY[fb.direction] * fb.speed) % n;
						if (nx < 0) {
							nx += n;
						}
						if (ny < 0) {
							ny += n;
						}
						if (copy[nx][ny] == null) {
							copy[nx][ny] = new ArrayList<>();
						}
						copy[nx][ny].add(new FireBall(fb.mass, fb.speed, fb.direction));
						map[i][j].remove(idx);
					}
				}
			}
		}
		map = copy;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != null && map[i][j].size() >= 2) {
					int count = map[i][j].size();
					boolean isDirectionEven = (map[i][j].get(count - 1).direction % 2 == 0 ? true : false);
					boolean isSame = true;
					int massTotal = 0, speedTotal = 0;
					for (int idx = count - 1; idx >= 0; idx--) {
						FireBall fb = map[i][j].get(idx);
						massTotal += fb.mass;
						speedTotal += fb.speed;
						if (isSame && idx != count - 1 && (fb.direction % 2 != 0 && isDirectionEven) || (fb.direction % 2 == 0 && !isDirectionEven)) {
							isSame = false;
						}
						map[i][j].remove(idx);
					}
					massTotal /= 5;
					if (massTotal != 0) {
						speedTotal /= count;
						map[i][j] = new ArrayList<>();
						if (isSame) {
							int dir = 0;
							for (int idx = 0; idx < 4; idx++) {
								map[i][j].add(new FireBall(massTotal, speedTotal, dir));
								dir += 2;
							}
						} else {
							int dir = 1;
							for (int idx = 0; idx < 4; idx++) {
								map[i][j].add(new FireBall(massTotal, speedTotal, dir));
								dir += 2;
							}
						}
					}
				}
			}
		}
	}
}
