import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, res;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		res = 0;
		
		//	인덱스: 행, 값: 열
		for (int col = 0; col < N; col++) {
			map = new int[N];
			map[0] = col;
			solve(1);
		}

		System.out.println(res);

	}

	private static void solve(int row) {

		if (row == N) {
			res++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[row] = i;
			if (check(row)) {
				solve(row + 1);
			}
		}

	}

	private static boolean check(int row) {
		
		for (int i = 0; i < row; i++) {
			if (map[i] == map[row]) {
				return false;
			}
			if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {
				return false;
			}
		}
		return true;
    
	}

}
