import java.io.*;
import java.util.*;

public class Main {
	
	private static class Line implements Comparable<Line> {
		int start, end;
		
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Line o) {
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Line> lst = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lst.add(new Line(start, end));
		}
		
		Collections.sort(lst);
		
		int answer = 0, min = lst.get(0).start, max = lst.get(0).end;
		
		for (int i = 1; i < N; i++) {
			if (lst.get(i).start <= max) {
				max = Math.max(max, lst.get(i).end);
			} else {
				answer += max - min;
				min = lst.get(i).start;
				max = lst.get(i).end;
			}
		}
		
		answer += max - min;
		
		System.out.println(answer);
		br.close();
	}
	
}
