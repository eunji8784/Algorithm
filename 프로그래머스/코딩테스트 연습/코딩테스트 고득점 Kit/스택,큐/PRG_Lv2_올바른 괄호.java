import java.util.*;

// 큐
class Solution {
    boolean solution(String s) {
        Queue<Character> que = new LinkedList<>();
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (c == ')') {
                if (que.isEmpty()) return false;
                que.poll();
            } else {
                que.offer(c);
            }
        }
        
        return que.size() == 0 ? true : false;
    }
}

// 스택
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.size() == 0 ? true : false;
    }
}

// 큐 사용 결과
// 테스트 1 〉	통과 (0.21ms, 76MB)
// 테스트 2 〉	통과 (0.11ms, 73.5MB)
// 테스트 3 〉	통과 (0.14ms, 70.9MB)
// 테스트 4 〉	통과 (0.25ms, 76.2MB)
// 테스트 5 〉	통과 (0.19ms, 73.3MB)
// 테스트 6 〉	통과 (0.12ms, 76MB)
// 테스트 7 〉	통과 (0.18ms, 69.4MB)
// 테스트 8 〉	통과 (0.27ms, 73.2MB)
// 테스트 9 〉	통과 (0.21ms, 80.9MB)
// 테스트 10 〉	통과 (0.23ms, 71.8MB)
// 테스트 11 〉	통과 (0.25ms, 74.3MB)
// 테스트 12 〉	통과 (0.27ms, 73.7MB)
// 테스트 13 〉	통과 (0.23ms, 75MB)
// 테스트 14 〉	통과 (0.20ms, 74.9MB)
// 테스트 15 〉	통과 (0.21ms, 76.1MB)
// 테스트 16 〉	통과 (0.24ms, 73MB)
// 테스트 17 〉	통과 (0.23ms, 76MB)
// 테스트 18 〉	통과 (0.20ms, 75.8MB)
// 효율성  테스트
// 테스트 1 〉	통과 (14.35ms, 53.7MB)
// 테스트 2 〉	통과 (14.24ms, 53.8MB)

// 스택 사용 결과
// 테스트 1 〉	통과 (0.22ms, 77.6MB)
// 테스트 2 〉	통과 (0.10ms, 85.9MB)
// 테스트 3 〉	통과 (0.09ms, 73.1MB)
// 테스트 4 〉	통과 (0.22ms, 73.2MB)
// 테스트 5 〉	통과 (0.27ms, 79MB)
// 테스트 6 〉	통과 (0.10ms, 76.4MB)
// 테스트 7 〉	통과 (0.20ms, 72.9MB)
// 테스트 8 〉	통과 (0.24ms, 72.9MB)
// 테스트 9 〉	통과 (0.19ms, 73.7MB)
// 테스트 10 〉	통과 (0.18ms, 74.7MB)
// 테스트 11 〉	통과 (0.19ms, 75.6MB)
// 테스트 12 〉	통과 (0.21ms, 76.3MB)
// 테스트 13 〉	통과 (0.22ms, 70.1MB)
// 테스트 14 〉	통과 (0.32ms, 71.6MB)
// 테스트 15 〉	통과 (0.30ms, 78.1MB)
// 테스트 16 〉	통과 (0.32ms, 73.7MB)
// 테스트 17 〉	통과 (0.29ms, 74.1MB)
// 테스트 18 〉	통과 (0.32ms, 77.3MB)
// 효율성  테스트
// 테스트 1 〉	통과 (18.17ms, 53.8MB)
// 테스트 2 〉	통과 (16.32ms, 52.9MB)
