import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[] dp = new int[N + 1];
      int sum = 0;

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        sum += Integer.parseInt(st.nextToken());
        dp[i] = sum;
      }

      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double total = dp[b] - dp[a - 1];
        double average = Math.round(total / (b - a + 1) * 100.0) / 100.0;
        sb.append(String.format("%.2f", average)).append("\n");
      }

      System.out.print(sb.toString());
    }
}
