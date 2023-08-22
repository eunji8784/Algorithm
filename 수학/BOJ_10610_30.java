import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] chrArr = br.readLine().toCharArray();
		Integer[] arr = new Integer[chrArr.length];
    
		boolean hasZero = false;
		int sum = 0;

		for (int i = 0; i < chrArr.length; i++) {
			arr[i] = Character.getNumericValue(chrArr[i]);
			sum += arr[i];
			if (arr[i] == 0) hasZero = true;
		}

		if (!hasZero || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			Arrays.sort(arr, Comparator.reverseOrder());     
			StringBuilder sb = new StringBuilder();
			for (int num : arr) {
				sb.append(num);
			}
			System.out.println(sb.toString());
		}
		
		br.close();
	}

}
