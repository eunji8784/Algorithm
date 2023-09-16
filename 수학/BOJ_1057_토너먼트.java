import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		int answer = 1;
		
		while (N >= 1) {
			kim = (kim % 2 == 0 ? kim / 2 : kim / 2 + 1);
			lim = (lim % 2 == 0 ? lim / 2 : lim / 2 + 1);
			
			if (kim == lim) {
				System.out.println(answer);
				System.exit(0);
			}
			
			answer++;
			N /= 2;
		}
		
		System.out.println(-1);
		br.close();
	}

}
