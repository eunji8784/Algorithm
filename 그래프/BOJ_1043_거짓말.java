import java.io.*;
import java.util.*;

public class Main {
	private static class UnionFind {
		int[] parent;

		public UnionFind(int n) {
			parent = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
		}

		public void union(int x, int y) {
			x = find(x);
			y = find(y);
			if (x != y) {
				parent[y] = x;
			}
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			} else {
				return parent[x] = find(parent[x]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int peopleCount = Integer.parseInt(st.nextToken());
		int partyCount = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int knownCount = Integer.parseInt(st.nextToken());

		if (knownCount == 0) {
			bw.write(String.valueOf(partyCount));
			bw.flush();
			return;
		}

		UnionFind uf = new UnionFind(peopleCount);
       		int[] party = new int[partyCount + 1];
		int firstKnown = Integer.parseInt(st.nextToken()); 
		
		for (int i = 0; i < knownCount - 1; i++) {
			int person = Integer.parseInt(st.nextToken());
			uf.parent[person] = firstKnown;
		}
		
		for (int i = 1; i <= partyCount; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			party[i] = first;
			for (int j = 0; j < count - 1; j++) {
				int person = Integer.parseInt(st.nextToken());
				uf.union(first, person);
			}
		}
		
		int maxCount = partyCount;
		int known = uf.find(firstKnown);

		for (int i = 1; i <= partyCount; i++) {
			if (uf.find(party[i]) == known) {
				maxCount--;
			}
		}

		bw.write(String.valueOf(maxCount));
		bw.flush();
		bw.close();
		br.close();
	}

}
