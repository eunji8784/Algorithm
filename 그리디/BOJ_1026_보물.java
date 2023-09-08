import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(B, (o1, o2) -> o2 - o1);
		Arrays.sort(A);
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			answer += A[i] * B[i];
		}
		
		System.out.println(answer);
		br.close();
	}

}
