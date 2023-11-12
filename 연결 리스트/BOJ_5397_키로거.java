import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String str = br.readLine();
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				char chr = str.charAt(i);
				switch(chr) {
				case '<':
					if (!left.isEmpty()) right.push(left.pop());
					break;
				case '>':
					if (!right.isEmpty()) left.push(right.pop());
					break;
				case '-':
					if (!left.isEmpty()) left.pop();
					break;
				default:
					left.push(chr);
				}
			}
			
			for (int i = 0; i < left.size(); i++) {
				bw.write(left.get(i));
			}
			
			while (!right.isEmpty()) {
				bw.write(right.pop());
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
