import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String expression = br.readLine();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		
		for (int i = 0; i < expression.length(); i++) {
			char chr = expression.charAt(i);
			if (chr == '(') {
				stack.push(chr);
			} else {
				stack.pop();
				if (expression.charAt(i - 1) == ')') {
					answer++;
				} else {
					answer += stack.size();
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.close();
		br.close();
	}
}

// Stack 없이 count만으로 구현
// public class Main {
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		String expression = br.readLine();
// 		int count = 0, answer = 0;
		
// 		for (int i = 0; i < expression.length(); i++) {
// 			char chr = expression.charAt(i);
// 			if (chr == '(') {
// 				count++;
// 			} else {
// 				count--;
// 				if (expression.charAt(i - 1) == ')') {
// 					answer++;
// 				} else {
// 					answer += count;
// 				}
// 			}
// 		}
		
// 		bw.write(answer + "\n");
// 		bw.close();
// 		br.close();
// 	}
// }
