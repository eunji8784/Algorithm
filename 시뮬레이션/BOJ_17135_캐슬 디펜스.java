import java.io.*;
import java.util.*;

public class Main {
	private static int N, M, D, max;
	private static int[][] map;
	private static List<int[]> lst;
	
	private static class Anemy implements Comparable<Anemy> {
		int x, y, dist;
		
		public Anemy(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Anemy o) {
			if (this.dist == o.dist) return this.y - o.y;
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		max = 0;
		map = new int[N][M];
		lst = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) lst.add(new int[] {i, j});
			}
		}
		
		comb(0, 0, new int[3]);
		
		System.out.println(max);
		br.close();
	}
	
	private static void comb(int index, int count, int[] archer) {
		if (count == 3) {
			List<int[]> anemys = copyList();
			solve(archer, anemys);
			return;
		}
		
		for (int i = index; i < M; i++) {
			archer[count] = i;
			comb(i + 1, count + 1, archer);
		}
	}
	
	private static List<int[]> copyList() {
		List<int[]> copy = new ArrayList<>();
		for (int i = 0; i < lst.size(); i++) {
			int x = lst.get(i)[0];
			int y = lst.get(i)[1];
			copy.add(new int[] {x, y});
		}
		return copy;
	}

	private static void solve(int[] archer, List<int[]> anemys) {
		int kill = 0;
		
		while (!anemys.isEmpty()) { // 적을 모두 잡을때까지
			List<int[]> targets = new ArrayList<>(); // 한 턴에 죽일 적들 리스트
			
			for (int attackY : archer) {
				// 한 궁수가 죽일 수 있는 적들의 위치
				PriorityQueue<Anemy> pq = new PriorityQueue<>(); 
				
				for (int i = 0; i < anemys.size(); i++) {
					int dist = Math.abs(anemys.get(i)[0] - N) + Math.abs(anemys.get(i)[1] - attackY);
					if (dist <= D) {
						pq.offer(new Anemy(anemys.get(i)[0], anemys.get(i)[1], dist));
					}
				}
				
				if (pq.isEmpty()) continue;
				
				Anemy target = pq.poll(); // 한 궁수가 죽일 최종적인 적의 위치 
				boolean flag = true;
				for (int i = 0; i < targets.size(); i++) {
					if (targets.get(i)[0] == target.x && targets.get(i)[1] == target.y) {
						flag = false;
						break;
					}
				}
				
				if (flag) { // 중복되는 적이 아니면 targets 리스트에 추가한다. 
					targets.add(new int[] {target.x, target.y});
				}
			}
			
			// 죽인 적들의 수를 카운팅한다.
			kill += targets.size();
			
			// 죽일 적들을 제거한다.
			for (int i = 0; i < targets.size(); i++) {
				for (int j = anemys.size() - 1; j >= 0; j--) {
					int x = anemys.get(j)[0];
					int y = anemys.get(j)[1];
					if (x == targets.get(i)[0] && y == targets.get(i)[1]) {
						anemys.remove(j);
						break;
					}
				}
			}
			
			// 적들의 위치를 한 칸 아래로 내린다. 
			for (int i = anemys.size() - 1; i >= 0; i--) {
				anemys.get(i)[0]++;
				if (anemys.get(i)[0] == N) {
					anemys.remove(i);
				}
			}
		}
		
		max = Math.max(max, kill);
	}
}
