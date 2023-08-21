import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int fromLeft = (j == 0) ? 0 : triangle[i - 1][j - 1];
				int fromRight = (j == i) ? 0 : triangle[i - 1][j];
				
				triangle[i][j] += Math.max(fromLeft, fromRight); 
			}
		}
		
		int answer = -1;
		
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, triangle[n - 1][i]);
		}
		
		System.out.println(answer);
		
		br.close();
	}

}

/*
 
 *
 * *
 * * *  
 * * * *
 * * * * *
 * * * * * *

      *
     * *
    * * *
   * * * * 
  * * * * *
 * * * * * *
 */
