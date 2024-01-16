import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		int time = 0, weight = 0;

		while (!bridge.isEmpty()) {
			weight -= bridge.poll();
			time++;

			if (!trucks.isEmpty()) {
				int nextTruck = trucks.peek();
				if (weight + nextTruck <= l) {
					bridge.add(trucks.poll());
					weight += nextTruck;
				} else {
					bridge.add(0);
				}
			}
		}

		bw.write(String.valueOf(time));
		bw.close();
		br.close();
	}
}
