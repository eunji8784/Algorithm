import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
		int k = Integer.parseInt(st.nextToken()); // 전기 용품의 총 사용횟수
		int[] schedule = new int[k];
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> use = new HashSet<>(n);

		for (int i = 0; i < k; i++) {
			int now = schedule[i];

			if (use.contains(now)) {
				continue;
			}

			if (use.size() < n) {
				use.add(now);
				continue;
			}

			Iterator<Integer> iterator = use.iterator();

			int toRemove = -1;
			int lastIdx = -1;

			while (iterator.hasNext()) {
				int device = iterator.next();
				int idx = Integer.MAX_VALUE;

				for (int j = i + 1; j < k; j++) {
					if (schedule[j] == device) {
						idx = j;
						break;
					}
				}

				if (idx > lastIdx) {
					lastIdx = idx;
					toRemove = device;
				}
			}

			answer++;
			use.remove(toRemove);
			use.add(now);
		}

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}
}
