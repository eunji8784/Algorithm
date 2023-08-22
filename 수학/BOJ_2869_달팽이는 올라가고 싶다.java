import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int ans = 0;

		ans = (V - A) / (A - B) + ((V - A) % (A - B) == 0 ? 1 : 2);

		System.out.println(ans);
		br.close();
	}

}
