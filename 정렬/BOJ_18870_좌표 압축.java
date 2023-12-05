import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[] keys = new int[n];
		int[] sort = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			keys[i] = num;
			sort[i] = num;
		}

		Arrays.sort(sort);
		
		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int num : sort) {
			if (!map.containsKey(num)) {
				map.put(num, idx++);
			}
		}
		
		for (int key : keys) {
			bw.write(map.get(key) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
