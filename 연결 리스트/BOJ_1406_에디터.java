import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			left.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);
			char chr = ' ';
			if (st.hasMoreTokens()) {
				chr = st.nextToken().charAt(0);
			}
			
			switch(command) {
			case 'L':
				if (!left.isEmpty()) right.add(left.pop());
				break;
			case 'D':
				if (!right.isEmpty()) left.add(right.pop());
				break;
			case 'B':
				if (!left.isEmpty()) left.pop();
				break;
			case 'P':
				left.add(chr);
			}
		}
		
		for (int i = 0; i < left.size(); i++) {
			bw.write(left.get(i));
		}
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
