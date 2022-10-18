import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int num = 0;
	static int r;
	static int c;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = (int) Math.pow(2, N);
		
		division(0, 0, n);
		
	}

	private static void division(int x, int y, int size) {
		
		if (x == r && y == c) {
		    System.out.println(num);
		    return;
		}
		
		if (x <= r && r < (x + size) && y <= c && c < (y + size)) {
			int newSize = size / 2;
			division(x, y, newSize);
			division(x, y + newSize, newSize);
			division(x + newSize, y, newSize);
			division(x + newSize, y + newSize, newSize);
		} else {
			num += size * size;
		}
		
	}
	
}
