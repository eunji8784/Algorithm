import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 1, range = 1;

		while (N > range) {
			range += (ans++ * 6);
		}

		System.out.println(ans);
		br.close();
	}

}a
