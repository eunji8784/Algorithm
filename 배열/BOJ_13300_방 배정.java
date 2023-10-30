import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] students = new int[7][2];
		int room = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			students[Y][S]++;
		}
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				room += students[i][j] / K;
				if (students[i][j] % K != 0) room++;
			}
		}
		
		System.out.println(room);
		br.close();
	}
}
