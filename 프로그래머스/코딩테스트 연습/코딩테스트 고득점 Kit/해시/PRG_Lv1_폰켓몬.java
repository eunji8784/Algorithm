import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) map.put(n, 1);
        
        return map.size() >= num ? num : map.size();
    }
}

// 테스트 1 〉	통과 (0.02ms, 85.5MB)
// 테스트 2 〉	통과 (0.09ms, 82.7MB)
// 테스트 3 〉	통과 (0.06ms, 73.6MB)
// 테스트 4 〉	통과 (0.04ms, 79.1MB)
// 테스트 5 〉	통과 (0.04ms, 64.7MB)
// 테스트 6 〉	통과 (0.04ms, 77MB)
// 테스트 7 〉	통과 (0.23ms, 72.5MB)
// 테스트 8 〉	통과 (0.30ms, 70.9MB)
// 테스트 9 〉	통과 (0.23ms, 73MB)
// 테스트 10 〉	통과 (0.20ms, 72.5MB)
// 테스트 11 〉	통과 (0.23ms, 76.5MB)
// 테스트 12 〉	통과 (0.37ms, 72.8MB)
// 테스트 13 〉	통과 (0.74ms, 77.2MB)
// 테스트 14 〉	통과 (0.48ms, 77.7MB)
// 테스트 15 〉	통과 (0.72ms, 78.7MB)
// 테스트 16 〉	통과 (2.69ms, 82.8MB)
// 테스트 17 〉	통과 (5.43ms, 78.5MB)
// 테스트 18 〉	통과 (4.56ms, 74.5MB)
// 테스트 19 〉	통과 (4.10ms, 86.2MB)
// 테스트 20 〉	통과 (2.60ms, 82.1MB)
