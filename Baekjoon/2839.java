import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		while (true) {

			if (N % 5 == 0) {
      
				result += N / 5;
				break;
        
			} else {
      
				if (N - 3 < 0) {
        
					result = -1;
					break;
          
				} else {
        
					N -= 3;
					result++;

					if (N == 0)
						break;
            
				}
        
			}

		}
		
		System.out.println(result);

	}

}
