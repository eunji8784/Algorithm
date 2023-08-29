import java.io.*;
import java.util.*;

public class Main {
	
	private static int n, k;
	private static int[] cards;
	private static boolean[] vst;
	private static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		cards = new int[n];
		vst = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}

		permutation("", 0);
		
		System.out.println(set.size());
		br.close();
	}

	private static void permutation(String num, int depth) {
		if (depth == k) {
			set.add(num);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!vst[i]) {
				vst[i] = true;
				permutation(num + cards[i], depth + 1);
				vst[i] = false;
			}
		}
		
	}
}
