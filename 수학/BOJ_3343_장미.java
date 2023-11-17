import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());
		
		if (A < C) {
			long tmp = A;
			A = C;
			C = tmp;
			tmp = B;
			B = D;
			D = tmp;
		}
		
		long count = 0, min = Long.MAX_VALUE;
        
		while (true) {
			if (A * count >= N) {
				min = Math.min(min, B * count);
				break;
			}
			long cost = B * count;
			long remain = N - (A * count);
			long num = remain % C == 0 ? remain / C : (remain / C) + 1;
			cost += (num * D);
			min = Math.min(min, cost);
			count++;
		}
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
}
