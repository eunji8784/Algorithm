import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int box[] = new int[100];
		
		for(int tc = 1; tc <= T; tc++) {
      
			int dumpCount = Integer.parseInt(in.readLine());
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			while (dumpCount-- > 0) {
				Arrays.sort(box);
				box[0]++;
				box[99]--;
			}
			
			Arrays.sort(box);
			
			System.out.printf("#%d %d\n", tc, box[99] - box[0]);
      
		}
    
	}

}
