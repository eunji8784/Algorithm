import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. 시간, 메모리
// R, C의 최댓값 1500 -> 매일 배열의 모든 구간을 탐색할 경우 시간 초과 발생
// 큐, 방문 체크 배열 여러 개 만들면 메모리 초과 발생 -> 꼭 필요한 것만 생성

// 2. 백조 이동
// 두 백조의 인접 여부는 bfs로 확인하되, 탐색할 때 백조가 빙하('X')를 만나면 해당 빙하('X')의 위치를 새로운 큐에 저장하고 다음 날 해당 위치부터 탐색을 시작한다.  
// -> 백조가 빙하('X')를 만났다는 건 해당 빙하가 물과 인접해 있다는 뜻이므로 다음 날에 빙하가 녹아 무조건 백조가 지나갈 수 있다.

// ..XXX...X..
// .X.XXX...L.
// ....XXX..X.
// X.L..XXX...

// ...X.......
// ....X....L.
// .....X.....
// ..L...X....


// 3. 빙하 녹이기
// 입력받을 때 물('.', 'L')의 위치를 큐에 저장한다.
// 인접한 빙하('X')의 위치를 큐에 저장한 뒤 녹인다('.') 
// 전날에 녹였던 빙하의 위치부터 탐색한다.


public class Main {

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 X값 
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우 Y값
	static int R, C; // 2차원 배열의 행, 열
	static char[][] lake; // 전체 2차원 배열
	static int[] swanLocX, swanLocY;  // 두 백조의 위치
	static Queue<Point> water, swan; // 탐색할 물의 위치 저장 큐, 탐색할 백조의 위치 저장 큐 

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		swanLocX = new int[2];
		swanLocY = new int[2];
		water = new LinkedList<>();
		int idx = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			lake[i] = str.toCharArray();
			for (int j = 0; j < C; j++) {
				if (lake[i][j] == 'L') {
					swanLocX[idx] = i;
					swanLocY[idx++] = j;
				}
				if (lake[i][j] == '.' || lake[i][j] == 'L') { // 주의사항: 백조('L')가 있는 곳도 물이므로 큐에 저장
					water.offer(new Point(i, j));
				}
			}
		}

		// 백조의 위치를 담을 큐
		swan = new LinkedList<>();
		// 백조의 방문 여부를 체크할 boolean 배열
		boolean[][] swanVst = new boolean[R][C];
		// 첫 백조의 위치부터 탐색을 시작한다.
		swan.offer(new Point(swanLocX[0], swanLocY[0]));
		// 첫 백조의 위치 방문 체크
		swanVst[swanLocX[0]][swanLocY[0]] = true;

		int Ans = 0;
		while (!swanCanMeet(swanVst)) { // 두 백조가 만나면 반복문을 종료한다. 
			Ans++; 
			icebergMelts(); // 빙하 녹이기
		}
		br.close();
		System.out.println(Ans);

	}

	private static boolean swanCanMeet(boolean[][] swanVst) {

		// 다음 날 탐색할 위치를 저장할 큐
		Queue<Point> next = new LinkedList<>();

		while (!swan.isEmpty()) {
			Point current = swan.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || swanVst[nx][ny]) {
					continue;
				}
				// 두 백조가 만나면 함수를 종료한다.
				if (nx == swanLocX[1] && ny == swanLocY[1]) {
					return true;
				}
				if (lake[nx][ny] == '.') {
					swan.offer(new Point(nx, ny));
				} else if (lake[nx][ny] == 'X') {
					next.offer(new Point(nx, ny));
				}
				swanVst[nx][ny] = true;
			}
		}

		// 백조 큐에 다음 날 탐색할 위치 저장
		swan = next;

		return false;

	}

	private static void icebergMelts() {

		int size = water.size();

		for (int idx = 0; idx < size; idx++) {
			Point current = water.poll();
			int x = current.x;
			int y = current.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					continue;
				}

				if (lake[nx][ny] == 'X') {
					lake[nx][ny] = '.';
					water.offer(new Point(nx, ny));
				}
			}

		}

	}

}
