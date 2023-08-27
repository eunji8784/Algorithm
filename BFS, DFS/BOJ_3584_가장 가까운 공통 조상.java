import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] lst = new int[N + 1];
			ArrayList<Integer> lst1 = new ArrayList<>();
			ArrayList<Integer> lst2 = new ArrayList<>();

			StringTokenizer st;
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int children = Integer.parseInt(st.nextToken());
				lst[children] = parent;
			}

			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			if (node1 == node2) {
				System.out.println(lst[node1]);
				System.exit(0);
			}

			while (node1 > 0) {
				lst1.add(node1);
				node1 = lst[node1];
			}
			
			while (node2 > 0) {
				lst2.add(node2);
				node2 = lst[node2];
			}
			
			int idx1 = lst1.size() - 1;
			int idx2 = lst2.size() - 1;
			
			while (idx1 >= 0 && idx2 >= 0 && lst1.get(idx1).intValue() == lst2.get(idx2).intValue()) {
				idx1--;
				idx2--;
			}
			
			System.out.println(lst1.get(idx1 + 1));
		}

		br.close();
	}
}
