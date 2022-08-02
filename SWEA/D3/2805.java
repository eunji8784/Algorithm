import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(in.readLine());
			int farm[][] = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				
				String tmp_str = in.readLine();
				String tmp_arr[] = tmp_str.split("");
				
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(tmp_arr[j]);
				}
				
			}
			
			int sum = 0;
			int count = 1;
			int tmp;
			int start_idx = (N-1)/2; 
			
			for (int i = 0; i < N; i++) {
				
				tmp = start_idx;
				for (int j = 0; j < count; j++) {
					sum += farm[i][tmp++];
				}
				
				if (i >= (N-1)/2) {
					count -= 2;
					start_idx++;
				} else {
					count += 2;
					start_idx--;
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}

	}

}
