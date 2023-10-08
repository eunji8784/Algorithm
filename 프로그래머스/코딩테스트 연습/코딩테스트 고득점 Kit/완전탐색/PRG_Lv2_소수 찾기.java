import java.util.*;

class Solution {
    private static int answer;
    private static boolean[] vst;
    private static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;     
        vst = new boolean[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) permutation("", numbers, 0, i);
        return answer;
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private static void permutation(String str, String numbers, int count, int size) {
        if (count == size) {
            int n = Integer.parseInt(str);
            if (!set.contains(n)) {
                set.add(n);
                if (isPrime(n)) answer++;    
            }
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!vst[i] && !(count == 0 && numbers.charAt(i) == '0')) {
                vst[i] = true;
                permutation(str + numbers.charAt(i), numbers, count + 1, size);
                vst[i] = false;
            }
        }
    }
}

// 테스트 1 〉	통과 (16.43ms, 80.2MB)
// 테스트 2 〉	통과 (19.16ms, 74.3MB)
// 테스트 3 〉	통과 (14.41ms, 80.6MB)
// 테스트 4 〉	통과 (29.07ms, 87.9MB)
// 테스트 5 〉	통과 (31.64ms, 87.5MB)
// 테스트 6 〉	통과 (17.21ms, 83.1MB)
// 테스트 7 〉	통과 (14.48ms, 74.5MB)
// 테스트 8 〉	통과 (44.27ms, 88MB)
// 테스트 9 〉	통과 (19.24ms, 81.8MB)
// 테스트 10 〉	통과 (24.62ms, 67.2MB)
// 테스트 11 〉	통과 (17.13ms, 84.7MB)
// 테스트 12 〉	통과 (22.14ms, 75.8MB)
