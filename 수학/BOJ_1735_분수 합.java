import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int lcm = lcm(b, d); // 최소공배수 
		int numerator = a * (lcm / b) + c * (lcm / d); // 분자 
		int denominator = lcm; // 분모 
		int gcd = gcd(numerator, denominator); // 최대공약수 
		
		System.out.println((numerator / gcd) + " " + (denominator / gcd));
		br.close();
	}
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
