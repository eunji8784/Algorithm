import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String infix = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		char chr;
		
		for (int i = 0; i < infix.length(); i++) {
			
			chr = infix.charAt(i);
			
			if ('A' <= chr && chr <= 'Z') {
				sb.append(chr);
			} else { 
				if (chr == '*' || chr == '/') {
					while (!stack.isEmpty()) {
						if (stack.peek() == '/' || stack.peek() == '*') {
							sb.append(stack.pop());
						} else {
							break;
						}
					}
					stack.push(chr);
				} else if (chr == '+' || chr == '-') {
					while (!stack.isEmpty()) {
						if (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-') {
							sb.append(stack.pop());
						} else {
							break;
						}
					}
					stack.push(chr);
				} else if (chr == '(') {
					stack.push(chr);
				} else if (chr == ')') {
					while (true) {
						if (stack.peek() != '(') {
							sb.append(stack.pop());
						} else {
							stack.pop();
							break;
						}
					}
				}
			}
			
		}
		
		
		while (!stack.isEmpty()) {
			if (stack.peek() != '(') {
				sb.append(stack.pop());
			} else {
				stack.pop();
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
