import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> lst = new ArrayList<>();
        int[] result = new int[100];
        int[] day = new int[progresses.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < progresses.length; i++) {
            day[i] = (100 - progresses[i]) / speeds[i] + (((100 - progresses[i]) % speeds[i]) != 0 ? 1 : 0);
        }
        
        for (int n : day) {
            if (stack.isEmpty()) {
                stack.push(n);
                continue;
            }
            if (stack.peek() >= n) {
                result[stack.peek()]++;
            } else {
                lst.add(++result[stack.pop()]);
                stack.push(n);
            }
        }
        
        while (!stack.isEmpty()) {
            lst.add(++result[stack.pop()]);
        }
        
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.17ms, 75.7MB)
// 테스트 2 〉	통과 (0.30ms, 77MB)
// 테스트 3 〉	통과 (0.17ms, 75.2MB)
// 테스트 4 〉	통과 (0.15ms, 73.6MB)
// 테스트 5 〉	통과 (0.18ms, 77.5MB)
// 테스트 6 〉	통과 (0.21ms, 66.1MB)
// 테스트 7 〉	통과 (0.25ms, 78.1MB)
// 테스트 8 〉	통과 (0.16ms, 71.5MB)
// 테스트 9 〉	통과 (0.37ms, 70.6MB)
// 테스트 10 〉	통과 (0.26ms, 72MB)
// 테스트 11 〉	통과 (0.14ms, 75MB)
