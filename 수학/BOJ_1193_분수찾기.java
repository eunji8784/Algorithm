import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int line = 1;
		
		while (X > line) {
			X -= line++;
		}
		
		if (line % 2 == 0) {
			System.out.println(X + "/" + (line - X + 1));
		} else {
			System.out.println((line - X + 1) + "/" + X);
		}
		
		br.close();
	}

}
