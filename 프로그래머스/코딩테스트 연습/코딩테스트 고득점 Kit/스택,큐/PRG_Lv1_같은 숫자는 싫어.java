import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int n : arr) {
            if (!stack.isEmpty() && stack.peek() == n) continue;
            stack.push(n);
        }
        
        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        
        while (!stack.isEmpty()) {
            answer[idx--] = stack.pop();    
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.12ms, 73.1MB)
// 테스트 2 〉	통과 (0.21ms, 75.1MB)
// 테스트 3 〉	통과 (0.21ms, 72.5MB)
// 테스트 4 〉	통과 (0.20ms, 76.9MB)
// 테스트 5 〉	통과 (0.27ms, 72.4MB)
// 테스트 6 〉	통과 (0.20ms, 76.8MB)
// 테스트 7 〉	통과 (0.28ms, 73.5MB)
// 테스트 8 〉	통과 (0.20ms, 74.6MB)
// 테스트 9 〉	통과 (0.35ms, 75.3MB)
// 테스트 10 〉	통과 (0.20ms, 73.6MB)
// 테스트 11 〉	통과 (0.18ms, 82.4MB)
// 테스트 12 〉	통과 (0.19ms, 73.6MB)
// 테스트 13 〉	통과 (0.27ms, 74.1MB)
// 테스트 14 〉	통과 (0.27ms, 71.1MB)
// 테스트 15 〉	통과 (0.25ms, 77.8MB)
// 테스트 16 〉	통과 (0.38ms, 73.7MB)
// 테스트 17 〉	통과 (0.11ms, 71.7MB)
// 효율성  테스트
// 테스트 1 〉	통과 (51.63ms, 111MB)
// 테스트 2 〉	통과 (56.09ms, 112MB)
// 테스트 3 〉	통과 (52.37ms, 111MB)
// 테스트 4 〉	통과 (53.55ms, 118MB)
