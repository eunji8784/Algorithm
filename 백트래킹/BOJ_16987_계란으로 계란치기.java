import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, max = -1;
	private static int[][] eggs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 eggs[i][0] = Integer.parseInt(st.nextToken());
			 eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solution(0);
		
		System.out.println(max);
		br.close();
	}
	
	private static void solution(int idx) {
		if (idx == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i][0] <= 0) count++;
			}
			max = Math.max(max, count);
			return;
		}
		
		if (eggs[idx][0] <= 0) { // 현재 계란이 깨져있으면 다음 계란으로 
			solution(idx + 1);
			return;
		}
		
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (i == idx) continue; // 자기 자신은 치지 않음 
			if (eggs[i][0] > 0) {
				flag = true;
				eggs[idx][0] -= eggs[i][1];
				eggs[i][0] -= eggs[idx][1];
				solution(idx + 1);
				eggs[idx][0] += eggs[i][1];
				eggs[i][0] += eggs[idx][1];
			}
		}
		
		if (!flag) solution(idx + 1);
	}

} 
