import java.io.*;
import java.util.*;

/*
1. 모든 꽃을 피는 날짜에 대해 오름차순, 지는 날짜에 대해 내림차순으로 정렬.
2. 3월 1일부터 꽃을 심기 시작. 이 때 가장 늦게 지는 꽃을 선택. 선택한 꽃의 지는 날짜를 기록. 
3. 그 다음 날 (즉, 이전에 선택한 꽃이 지는 날 다음 날)부터 다시 꽃을 심을 수 있는지 확인. 이전에 선택한 꽃이 지는 날 이후에 피고, 이전에 기록한 지는 날 이전에 지는 꽃은 무시. 남은 꽃들 중에서 가장 늦게 지는 꽃을 선택하고, 그 꽃의 지는 날을 기록.
4. 이 과정을 선택한 꽃들 중 가장 늦게 지는 날이 11월 30일 이후가 될 때까지 반복. 만약 11월 30일 이전에 선택할 수 있는 꽃이 없다면, 문제의 조건을 만족시킬 수 없으므로 0을 출력.
5. 그렇지 않다면, 선택한 꽃들의 개수를 출력. 
*/

public class Main {
	
	private static int n;
	private static Flower[] flowers;
	
	private static class Flower implements Comparable<Flower> {
		int start;
		int end;

		Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower f) {
			if (this.start == f.start) {
				return Integer.compare(f.end, this.end);
			}
			return Integer.compare(this.start, f.start);
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		flowers = new Flower[n];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());

			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;
			flowers[i] = new Flower(start, end);
		}

		Arrays.sort(flowers); 
		
		solve();
		
		br.close();
	}

	private static void solve() {
		
		int startDay = 301;
		int endDay = 1201;
		int count = 0, max = 0, index = 0;

		while (startDay < endDay) {
			boolean isNewFlower = false; 

			for (int i = index; i < n; i++) {
				if (flowers[i].start > startDay) { 
					break;
				}

				if (flowers[i].end > max) {
					isNewFlower = true;
					max = flowers[i].end;
					index++;
				}
			}

			if (isNewFlower) {
				startDay = max;
				count++;
			} else {
				break;
			}
		}
		
		System.out.println(max < endDay ? 0 : count);
		
	}

}
