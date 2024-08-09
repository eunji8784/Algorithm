import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertNum = Integer.toString(n, k);
        String[] arr = convertNum.split("0");

        for (String tmp : arr) {
            if (tmp.isBlank()) continue;
            
            if (isPrime(Long.parseLong(tmp))) {
                answer++;
            }
        }
        
        return answer;
    }

    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

// 테스트 1 〉	통과 (11.27ms, 76.6MB)
// 테스트 2 〉	통과 (0.07ms, 73.3MB)
// 테스트 3 〉	통과 (0.14ms, 74.4MB)
// 테스트 4 〉	통과 (0.13ms, 76.9MB)
// 테스트 5 〉	통과 (0.19ms, 71.4MB)
// 테스트 6 〉	통과 (0.16ms, 76.1MB)
// 테스트 7 〉	통과 (0.24ms, 75.5MB)
// 테스트 8 〉	통과 (0.15ms, 71.3MB)
// 테스트 9 〉	통과 (0.11ms, 66MB)
// 테스트 10 〉	통과 (0.13ms, 74.4MB)
// 테스트 11 〉	통과 (0.07ms, 70.9MB)
// 테스트 12 〉	통과 (0.18ms, 76.4MB)
// 테스트 13 〉	통과 (0.15ms, 73.3MB)
// 테스트 14 〉	통과 (0.07ms, 74.5MB)
// 테스트 15 〉	통과 (0.08ms, 78.7MB)
// 테스트 16 〉	통과 (0.10ms, 78.5MB)
