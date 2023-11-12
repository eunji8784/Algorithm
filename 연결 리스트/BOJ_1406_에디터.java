import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		ListIterator<Character> iterator = list.listIterator();
		while (iterator.hasNext()) {
			iterator.next();
		}

		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			switch (command.charAt(0)) {
			case 'L':
				if (iterator.hasPrevious()) iterator.previous();
				break;
			case 'D':
				if (iterator.hasNext()) iterator.next();
				break;
			case 'B':
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
				break;
			case 'P':
				iterator.add(command.charAt(2));
			}
		}

		for (char chr : list) {
			bw.write(chr);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
