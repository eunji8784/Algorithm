import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			char[] funcs = br.readLine().toCharArray();

			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new LinkedList<>();
			String str = br.readLine();
			
			if (n != 0) {
				str = str.replace("[", "").replace("]", "");
				String[] tmp = str.split(",");

				for (int i = 0; i < tmp.length; i++) {
					dq.offer(Integer.parseInt(tmp[i]));
				}
			}

			StringBuilder sb = new StringBuilder();
			boolean isError = false;
			boolean isReversed = false; // 덱을 역순으로 뒤집어야 되는지를 나타내는 플래그 
			
			for (char func : funcs) {

				if (func == 'R') {
					isReversed = !isReversed;
				} else if (func == 'D') {
					if (dq.isEmpty()) {
						sb.append("error");
						isError = true;
						break;
					} else {
						if (isReversed) { // 덱이 뒤집혀 있다면
							dq.pollLast(); // 덱의 마지막 요소 제거
						} else { // 덱이 뒤집혀 있지 않다면
							dq.poll();  // 덱의 첫 번째 요소 제거
						}
					}
				}

			}

			if (!isError) {
				sb.append("[");
                while(!dq.isEmpty()) {
                    sb.append(isReversed ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }
                sb.append("]");
			}

			System.out.println(sb.toString());

		}

		br.close();

	}

}
