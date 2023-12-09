import java.io.*;
import java.util.*;

public class Main {
	private static final int[] DX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[] DY = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static int n, m, k;
	private static ArrayList<FireBall>[][] map;
	private static ArrayList<FireBall> fireBalls;

	private static class FireBall {
		int x, y, mass, speed, direction;

		public FireBall(int x, int y, int mass, int speed, int direction) {
			this.x = x;
			this.y = y;
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
		fireBalls = new ArrayList<>();

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls.add(new FireBall(r - 1, c - 1, m, s, d));
		}

		while (k-- > 0) {
			moveFireBall(); // 파이어볼 이동
			splitFireBall(); // 파이어볼 분열
		}

		int totalMass = 0;

		for (FireBall fb : fireBalls) {
			totalMass += fb.mass;
		}

		bw.write(String.valueOf(totalMass));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void moveFireBall() {
		for (FireBall fb : fireBalls) {
			int nx = (fb.x + DX[fb.direction] * fb.speed) % n;
			int ny = (fb.y + DY[fb.direction] * fb.speed) % n;
			if (nx < 0) {
				nx += n;
			}
			if (ny < 0) {
				ny += n;
			}
			fb.x = nx;
			fb.y = ny;
			if (map[nx][ny] == null) {
				map[nx][ny] = new ArrayList<>();
			}
			map[nx][ny].add(fb);
		}
	}

	private static void splitFireBall() {
		fireBalls.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == null) {
					continue;
				}
				if (map[i][j].size() == 1) {
					fireBalls.add(map[i][j].get(0));
					map[i][j].clear();
				}
				if (map[i][j].size() >= 2) {
					int count = map[i][j].size();
					boolean isDirectionEven = (map[i][j].get(count - 1).direction % 2 == 0 ? true : false);
					boolean isSame = true;
					int massTotal = 0, speedTotal = 0;
					for (int idx = count - 1; idx >= 0; idx--) {
						FireBall fb = map[i][j].get(idx);
						massTotal += fb.mass;
						speedTotal += fb.speed;
						if (isSame && idx != count - 1 && (fb.direction % 2 != 0 && isDirectionEven)
								|| (fb.direction % 2 == 0 && !isDirectionEven)) {
							isSame = false;
						}
						map[i][j].remove(idx);
					}
					massTotal /= 5;
					if (massTotal != 0) {
						speedTotal /= count;
						int dir = (isSame ? 0 : 1);
						int splitCount = 4;
						while (splitCount-- > 0) {
							fireBalls.add(new FireBall(i, j, massTotal, speedTotal, dir));
							dir += 2;
						}
					}
				}
			}
		}
	}
}
