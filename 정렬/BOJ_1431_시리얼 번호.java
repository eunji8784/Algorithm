import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);

    // bubble sort
		for (int i = 0; i < N - 1; i++) {

			for (int j = 0; j < N - 1; j++) {

				int length1 = arr[j].length();
				int length2 = arr[j + 1].length();

				if (length1 > length2) {
					swap(j, j + 1);
				}

				if (length1 == length2) {
					if (addNum(arr[j], arr[j])) {
						swap(j, j + 1);
					}
				}

			}

		}

		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str).append("\n");
		}

		System.out.print(sb.toString());
		br.close();

	}

	private static void swap(int i, int j) {

		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

	}

	private static boolean addNum(String str1, String str2) {

		int sum1 = 0;
		int sum2 = 0;

		str1 = str1.replaceAll("[^0-9]", "");
		for (char chr : str1.toCharArray()) {
			sum1 += Character.getNumericValue(chr);
		}

		str2 = str2.replaceAll("[^0-9]", "");
		for (char chr : str2.toCharArray()) {
			sum2 += Character.getNumericValue(chr);
		}

		if (sum1 > sum2) {
			return true;
		}

		return false;

	}

}
