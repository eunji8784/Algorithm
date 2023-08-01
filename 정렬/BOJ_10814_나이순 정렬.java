import java.io.*;
import java.util.*;

public class Main {

	public static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] p = new Person[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(p, (p1, p2) -> p1.age - p2.age);
		StringBuilder sb = new StringBuilder();
		for (Person person : p) {
			sb.append(person);
		}
		System.out.print(sb.toString());
		br.close();
	}

}
