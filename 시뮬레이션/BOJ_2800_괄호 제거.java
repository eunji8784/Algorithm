import java.io.*;
import java.util.*;

public class Main {
	private static String expression;
	private static TreeSet<String> treeSet;
	private static List<Pair> pairList;
	
	private static class Pair {
		int leftIdx, rightIdx;
		
		public Pair(int leftIdx, int rightIdx) {
			this.leftIdx = leftIdx;
			this.rightIdx = rightIdx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		expression = br.readLine();
		treeSet = new TreeSet<>();
		pairList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < expression.length(); i++) {
			char chr = expression.charAt(i);
			if (chr == '(') {
				stack.push(i);
			} else if (chr == ')') {
				pairList.add(new Pair(stack.pop(), i));
			}
		}
		
		solve(0, new boolean[pairList.size()]);
		
		treeSet.remove(expression);
		
		for (String answer : treeSet) {
			bw.write(answer + "\n");				
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void solve(int index, boolean[] remove) {
		if (index == pairList.size()) {
			boolean[] removed = new boolean[expression.length()];
			for (int i = 0; i < pairList.size(); i++) {
				if (remove[i]) {
					removed[pairList.get(i).leftIdx] = true;
					removed[pairList.get(i).rightIdx] = true;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < expression.length(); i++) {
				if (!removed[i]) {
					sb.append(expression.charAt(i));
				}
			}
			treeSet.add(sb.toString());
			return;
		}
		
		remove[index] = true;
		solve(index + 1, remove);
		
		remove[index] = false;
		solve(index + 1, remove);
	}
	
}
