import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		List<Integer> lst = new ArrayList<>(map.keySet());
		Collections.sort(lst, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(map.get(o2), map.get(o1));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (Integer key : lst) {
			for (int i = 0; i < map.get(key); i++) {
				sb.append(key + " ");
			}
		}

		System.out.println(sb.toString());
		br.close();

	}

}
