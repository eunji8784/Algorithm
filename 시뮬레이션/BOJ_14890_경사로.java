import java.io.*;
import java.util.*;

public class Main {
	private static int N, L;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (roadCheck(i, 0, true)) answer++; // 행 체크
			if (roadCheck(0, i, false)) answer++; // 열 체크 
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static boolean roadCheck(int row, int column, boolean isRow) {
		boolean[] vst = new boolean[N];
		int[] height = new int[N];
		
		for (int i = 0; i < N; i++) {
			height[i] = (isRow ? map[row][i] : map[i][column]);
		}
		
		for (int i = 0; i < N - 1; i++) {
			int diff = height[i] - height[i + 1];
			
			if (diff == 0) {
				continue;
			} else if (diff == 1) { // 내리막길 
				if (i + L >= N) return false;
				int num = height[i + 1];
				for (int l = 1; l <= L; l++) {
					if (vst[i + l] || height[i + l] != num) return false;
					vst[i + l] = true;
				}
			} else if (diff == -1) { // 오르막길 
				if (i < L - 1) return false;
				int num = height[i];
				for (int l = 0; l < L; l++) {
					if (vst[i - l] || height[i - l] != num) return false;
					vst[i - l] = true;
				}
			} else { // 높이 차이가 2 이상 
				return false;
			}
		}
		
		return true;
	}
 }
