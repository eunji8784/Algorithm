import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for (String num : set) {
            for (int i = 1; i < num.length(); i++) {
                if (set.contains(num.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}

// 테스트 1 〉	통과 (0.15ms, 75.2MB)
// 테스트 2 〉	통과 (0.16ms, 70.2MB)
// 테스트 3 〉	통과 (0.13ms, 75.8MB)
// 테스트 4 〉	통과 (0.16ms, 77.4MB)
// 테스트 5 〉	통과 (0.12ms, 75.9MB)
// 테스트 6 〉	통과 (0.18ms, 74.5MB)
// 테스트 7 〉	통과 (0.17ms, 76.8MB)
// 테스트 8 〉	통과 (0.11ms, 73.1MB)
// 테스트 9 〉	통과 (0.13ms, 72.3MB)
// 테스트 10 〉	통과 (0.11ms, 76.8MB)
// 테스트 11 〉	통과 (0.19ms, 74.8MB)
// 테스트 12 〉	통과 (0.14ms, 75.9MB)
// 테스트 13 〉	통과 (0.12ms, 75.8MB)
// 테스트 14 〉	통과 (1.80ms, 81.2MB)
// 테스트 15 〉	통과 (3.25ms, 74.6MB)
// 테스트 16 〉	통과 (5.84ms, 80.8MB)
// 테스트 17 〉	통과 (6.12ms, 81.9MB)
// 테스트 18 〉	통과 (6.61ms, 75.9MB)
// 테스트 19 〉	통과 (6.15ms, 78.5MB)
// 테스트 20 〉	통과 (5.21ms, 79.1MB)
// 효율성  테스트
// 테스트 1 〉	통과 (3.88ms, 56.4MB)
// 테스트 2 〉	통과 (3.74ms, 56.6MB)
// 테스트 3 〉	통과 (266.20ms, 214MB)
// 테스트 4 〉	통과 (347.75ms, 186MB)
