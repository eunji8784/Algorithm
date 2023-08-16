import java.io.*;
import java.util.*;

public class Main {

	private static int answer;
	private static int[] studentsPick;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			studentsPick = new int[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				studentsPick[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] vst = new boolean[n + 1];
			answer = 0;

			for (int i = 1; i <= n; i++) {
				if (!vst[i]) {
					vst[i] = true;
					if (i == studentsPick[i]) continue;
					solve(vst, i);
				}
			}
			
			System.out.println(answer);
		}

		br.close();
	}

	private static void solve(boolean[] vst, int studNum) {
		Set<Integer> set = new LinkedHashSet<>();
		set.add(studNum);
		
		int num = studNum;
		int key = 0;
		
		while (true) {
			int next = studentsPick[num];
			
			if (!vst[next]) {
				set.add(next);
				vst[next] = true;
				num = next;
				continue;
			}
			
			if (set.contains(next)) key = next;	
			break;
		}
		
		for (int s : set) {
			if (s == key) break;
			answer++;
		}
	}

}
