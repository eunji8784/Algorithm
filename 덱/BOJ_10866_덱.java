import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push_front":
				dq.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(dq.isEmpty() ? "-1" : dq.pollFirst()).append("\n");
				break;
			case "pop_back":
				sb.append(dq.isEmpty() ? "-1" : dq.pollLast()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty() ? "1" : "0").append("\n");
				break;
			case "front":
				sb.append(dq.isEmpty() ? "-1" : dq.peek()).append("\n");
				break;
			case "back":
				sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}

}
