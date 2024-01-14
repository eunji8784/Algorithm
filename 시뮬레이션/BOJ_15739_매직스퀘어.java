import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		boolean answer = true;
		int n = Integer.parseInt(br.readLine());
		int sum = n * ((int) Math.pow(n, 2) + 1) / 2;
		int[][] magicSquare = new int[n][n];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				// 행렬의 원소는 1부터 `n*n`(n의 제곱) 범위의 정수로 구성하며, 중복되는 수가 없이 모두 달라야 한다.
				if (num < 1 || num > n * n || set.contains(num)) {
					answer = false;
					break;
				}
				magicSquare[i][j] = num;
				set.add(num);
			}
		}

		if (answer) {
			set.clear();
			// 각 행의 합 구하기
			IntStream.range(0, n).mapToObj(i -> Arrays.stream(magicSquare[i]).sum()).forEach(set::add);
			// 각 열의 합 구하기
			IntStream.range(0, n).mapToObj(i -> IntStream.range(0, n).map(j -> magicSquare[i][j]).sum())
					.forEach(set::add);
			// 오른쪽 아래 대각선의 합 구하기
			set.add(IntStream.range(0, n).map(i -> magicSquare[i][i]).sum());
			// 왼쪽 아래 대각선의 합 구하기
			set.add(IntStream.range(0, n).map(i -> magicSquare[i][n - i - 1]).sum());
			if (set.size() != 1 || !set.contains(sum)) {
				answer = false;
			}
		}

		bw.write(answer ? "TRUE" : "FALSE");
		bw.close();
		br.close();
	}
}
