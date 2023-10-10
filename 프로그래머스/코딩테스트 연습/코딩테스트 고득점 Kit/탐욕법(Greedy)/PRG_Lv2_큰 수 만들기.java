class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int n = len - k;
        int start = 0;
        
        while (n > 0) {
            int i = start;
            int max = -1;
            while (len - i >= n) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    start = i;
                }
                i++;
            }
            answer.append(number.charAt(start++));
            n--;
        }
        
        return answer.toString();
    }
}

// 테스트 1 〉	통과 (0.11ms, 71.7MB)
// 테스트 2 〉	통과 (0.03ms, 75.2MB)
// 테스트 3 〉	통과 (0.06ms, 76.9MB)
// 테스트 4 〉	통과 (0.15ms, 73.7MB)
// 테스트 5 〉	통과 (0.48ms, 74MB)
// 테스트 6 〉	통과 (15.47ms, 77.1MB)
// 테스트 7 〉	통과 (37.08ms, 86.5MB)
// 테스트 8 〉	통과 (265.28ms, 87.1MB)
// 테스트 9 〉	통과 (24.94ms, 97.4MB)
// 테스트 10 〉	통과 (9306.86ms, 81.7MB)
// 테스트 11 〉	통과 (0.04ms, 75.1MB)
// 테스트 12 〉	통과 (0.05ms, 78.1MB)

import java.util.*;
// Stack을 이용한 풀이 (시간복잡도 Down)
class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        Stack<Character> stack = new Stack<>();
        char[] answer = new char[len - k];
        
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        
        return new String(answer);
    }
}

// 테스트 1 〉	통과 (0.20ms, 81.7MB)
// 테스트 2 〉	통과 (0.35ms, 78.3MB)
// 테스트 3 〉	통과 (0.43ms, 83.1MB)
// 테스트 4 〉	통과 (0.94ms, 87.2MB)
// 테스트 5 〉	통과 (1.47ms, 75.9MB)
// 테스트 6 〉	통과 (6.17ms, 74.3MB)
// 테스트 7 〉	통과 (19.11ms, 76.1MB)
// 테스트 8 〉	통과 (17.12ms, 88.3MB)
// 테스트 9 〉	통과 (42.41ms, 97.4MB)
// 테스트 10 〉	통과 (49.92ms, 84.9MB)
// 테스트 11 〉	통과 (0.20ms, 72.5MB)
// 테스트 12 〉	통과 (0.27ms, 74.4MB)
