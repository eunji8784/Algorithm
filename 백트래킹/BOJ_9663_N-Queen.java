import java.io.*;
import java.util.*;

public class Main {

	private static int N, answer = 0;
	private static int[] col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		col = new int[N]; // 인덱스: 행 , 값: 열

		permutation(0);
		
		System.out.println(answer);
	}

	private static void permutation(int depth) {
		if (depth == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			col[depth] = i;
			if (isPossible(depth)) {
				permutation(depth + 1);
			}
		}
	}

	private static boolean isPossible(int depth) {
		for (int i = 0; i < depth; i++) {
			if (col[i] == col[depth] || Math.abs(i - depth) - Math.abs(col[i] - col[depth]) == 0) {
				return false;
			}
		}
		return true;
	}

}
