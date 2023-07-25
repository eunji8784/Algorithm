import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		// 순서 유지
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for (int i = 0; i < L; i++) {
			String studNum = br.readLine();
			if (set.contains(studNum)) {
				set.remove(studNum);
			}
			set.add(studNum);
		}
		
		StringBuilder sb = new StringBuilder();
		for (String studNum : set) {
			if (cnt < K) {
				sb.append(studNum).append("\n");
			} else {
				break;
			}
			cnt++;
		}
		
		br.close();
		System.out.print(sb.toString());

	}

}
